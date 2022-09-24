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
package cloned.org.apache.logging.log4j.message;

/**
 * Creates messages. Implementations can provide different org.apache.logging.log4j.message format syntaxes.
 *
 * @see ParameterizedMessageFactory
 * @see StringFormatterMessageFactory
 */
public interface MessageFactory {

    /**
     * Creates a new org.apache.logging.log4j.message based on an Object.
     *
     * @param message
     *            a org.apache.logging.log4j.message object
     * @return a new org.apache.logging.log4j.message
     */
    Message newMessage(Object message);

    /**
     * Creates a new org.apache.logging.log4j.message based on a String.
     *
     * @param message
     *            a org.apache.logging.log4j.message String
     * @return a new org.apache.logging.log4j.message
     */
    Message newMessage(String message);

    /**
     * Creates a new parameterized org.apache.logging.log4j.message.
     *
     * @param message
     *            a org.apache.logging.log4j.message template, the kind of org.apache.logging.log4j.message template depends on the implementation.
     * @param params
     *            the org.apache.logging.log4j.message parameters
     * @return a new org.apache.logging.log4j.message
     * @see ParameterizedMessageFactory
     * @see StringFormatterMessageFactory
     */
    Message newMessage(String message, Object... params);
}
