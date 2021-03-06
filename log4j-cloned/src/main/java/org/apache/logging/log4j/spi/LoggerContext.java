/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.spi;

import org.apache.logging.log4j.message.MessageFactory;

/**
 * Anchor point for logging implementations.
 */
public interface LoggerContext {

    /**
     * An anchor for some other context, such as a ClassLoader or ServletContext.
     * @return The external context.
     */
    Object getExternalContext();

    /**
     * Retrieve an object by its name.
     * @param key The object's key.
     * @since 2.13.0
     */
    default Object getObject(String key) {
        return null;
    }

    /**
     * Store an object into the LoggerContext by name for later use.
     * @param key The object's key.
     * @param value The object.
     * @return The previous object or null.
     * @since 2.13.0
     */
    default Object putObject(String key, Object value) {
        return null;
    }

    /**
     * Store an object into the LoggerContext by name for later use if an object is not already stored with that key.
     * @param key The object's key.
     * @param value The object.
     * @return The previous object or null.
     * @since 2.13.0
     */
    default Object putObjectIfAbsent(String key, Object value) {
        return null;
    }

    /**
     * Remove an object if it is present.
     * @param key The object's key.
     * @return The object if it was present, null if it was not.
     * @since 2.13.0
     */
    default Object removeObject(String key) {
        return null;
    }

    /**
     * Remove an object if it is present and the provided object is stored.
     * @param key The object's key.
     * @param value The object.
     * @return The object if it was present, null if it was not.
     * @since 2.13.0
     */
    default boolean removeObject(String key, Object value) {
        return false;
    }

    /**
     * Returns an ExtendedLogger.
     * @param name The name of the org.apache.logging.log4j.Logger to return.
     * @return The logger with the specified name.
     */
    ExtendedLogger getLogger(String name);

    /**
     * Returns an ExtendedLogger using the fully qualified name of the Class as the org.apache.logging.log4j.Logger name.
     * @param cls The Class whose name should be used as the org.apache.logging.log4j.Logger name.
     * @return The logger.
     * @since 2.14.0
     */
    default ExtendedLogger getLogger(Class<?> cls) {
        final String canonicalName = cls.getCanonicalName();
        return getLogger(canonicalName != null ? canonicalName : cls.getName());
    }

    /**
     * Returns an ExtendedLogger.
     * @param name The name of the org.apache.logging.log4j.Logger to return.
     * @param messageFactory The org.apache.logging.log4j.message factory is used only when creating a logger, subsequent use does not change
     *                       the logger but will log a warning if mismatched.
     * @return The logger with the specified name.
     */
    ExtendedLogger getLogger(String name, MessageFactory messageFactory);

    /**
     * Returns an ExtendedLogger using the fully qualified name of the Class as the org.apache.logging.log4j.Logger name.
     * @param cls The Class whose name should be used as the org.apache.logging.log4j.Logger name.
     * @param messageFactory The org.apache.logging.log4j.message factory is used only when creating a logger, subsequent use does not change the
     *                       logger but will log a warning if mismatched.
     * @return The logger.
     * @since 2.14.0
     */
    default ExtendedLogger getLogger(Class<?> cls, MessageFactory messageFactory) {
        final String canonicalName = cls.getCanonicalName();
        return getLogger(canonicalName != null ? canonicalName : cls.getName(), messageFactory);
    }

    /**
     * Detects if a org.apache.logging.log4j.Logger with the specified name exists.
     * @param name The org.apache.logging.log4j.Logger name to search for.
     * @return true if the org.apache.logging.log4j.Logger exists, false otherwise.
     */
    boolean hasLogger(String name);

    /**
     * Detects if a org.apache.logging.log4j.Logger with the specified name and MessageFactory exists.
     * @param name The org.apache.logging.log4j.Logger name to search for.
     * @param messageFactory The org.apache.logging.log4j.message factory to search for.
     * @return true if the org.apache.logging.log4j.Logger exists, false otherwise.
     * @since 2.5
     */
    boolean hasLogger(String name, MessageFactory messageFactory);

    /**
     * Detects if a org.apache.logging.log4j.Logger with the specified name and MessageFactory type exists.
     * @param name The org.apache.logging.log4j.Logger name to search for.
     * @param messageFactoryClass The org.apache.logging.log4j.message factory class to search for.
     * @return true if the org.apache.logging.log4j.Logger exists, false otherwise.
     * @since 2.5
     */
    boolean hasLogger(String name, Class<? extends MessageFactory> messageFactoryClass);
}
