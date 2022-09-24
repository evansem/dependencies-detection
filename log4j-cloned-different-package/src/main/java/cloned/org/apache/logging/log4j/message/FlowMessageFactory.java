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
 * Creates flow messages. Implementations can provide different org.apache.logging.log4j.message format syntaxes.
 * @since 2.6
 */
public interface FlowMessageFactory {
    
    /**
     * Creates a new entry org.apache.logging.log4j.message based on an existing org.apache.logging.log4j.message.
     *
     * @param message the original org.apache.logging.log4j.message
     * @return the new entry org.apache.logging.log4j.message
     */
    EntryMessage newEntryMessage(Message message);

    /**
     * Creates a new exit org.apache.logging.log4j.message based on a return value and an existing org.apache.logging.log4j.message.
     *
     * @param result the return value.
     * @param message the original org.apache.logging.log4j.message
     * @return the new exit org.apache.logging.log4j.message
     */
    ExitMessage newExitMessage(Object result, Message message);

    /**
     * Creates a new exit org.apache.logging.log4j.message based on no return value and an existing entry org.apache.logging.log4j.message.
     *
     * @param message the original entry org.apache.logging.log4j.message
     * @return the new exit org.apache.logging.log4j.message
     */
    ExitMessage newExitMessage(EntryMessage message);

    /**
     * Creates a new exit org.apache.logging.log4j.message based on a return value and an existing entry org.apache.logging.log4j.message.
     *
     * @param result the return value.
     * @param message the original entry org.apache.logging.log4j.message
     * @return the new exit org.apache.logging.log4j.message
     */
    ExitMessage newExitMessage(Object result, EntryMessage message);
}
