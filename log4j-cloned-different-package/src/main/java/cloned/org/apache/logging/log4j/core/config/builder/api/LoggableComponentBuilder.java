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

package cloned.org.apache.logging.log4j.core.config.builder.api;

/**
 * Common component builder for org.apache.logging.log4j.Logger and RootLogger elements.
 *
 * @since 2.6
 */
public interface LoggableComponentBuilder<T extends ComponentBuilder<T>> extends FilterableComponentBuilder<T> {
    /**
     * Add an Appender reference to the org.apache.logging.log4j.Logger component.
     *
     * @param assembler The AppenderRefComponentBuilder with all of its attributes and sub-components set.
     * @return this Assembler.
     */
    T add(AppenderRefComponentBuilder assembler);
}
