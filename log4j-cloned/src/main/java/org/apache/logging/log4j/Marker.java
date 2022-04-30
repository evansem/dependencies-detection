package org.apache.logging.log4j;/*
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

import java.io.Serializable;

/**
 * Markers are objects that are used to add easily filterable information to log messages.
 *
 * Markers can be hierarchical - each org.apache.logging.log4j.Marker may have a parent. This allows for broad categories being subdivided into
 * more specific categories. An example might be a org.apache.logging.log4j.Marker named "Error" with children named "SystemError" and
 * "ApplicationError".
 */
public interface Marker extends Serializable {

    /**
     * Adds a org.apache.logging.log4j.Marker as a parent to this org.apache.logging.log4j.Marker.
     * 
     * @param markers The parent markers to add.
     * @return The current org.apache.logging.log4j.Marker object, thus allowing multiple adds to be concatenated.
     * @throws IllegalArgumentException if the argument is {@code null}
     */
    Marker addParents(Marker... markers);

    /**
     * Returns true if the given marker has the same name as this marker.
     *
     * @param obj the reference object with which to compare.
     * @return true if the given marker has the same name as this marker.
     * @since 2.4
     */
    @Override
    boolean equals(Object obj);

    /**
     * Returns the name of this org.apache.logging.log4j.Marker.
     * 
     * @return The name of the org.apache.logging.log4j.Marker.
     */
    String getName();

    /**
     * Returns a list of parents of this org.apache.logging.log4j.Marker.
     * 
     * @return The parent Markers or {@code null} if this org.apache.logging.log4j.Marker has no parents.
     */
    Marker[] getParents();

    /**
     * Returns a hash code value based on the name of this marker. Markers are equal if they have the same name.
     * 
     * @return the computed hash code
     * @since 2.4
     */
    @Override
    int hashCode();

    /**
     * Indicates whether this org.apache.logging.log4j.Marker has references to any other Markers.
     * 
     * @return {@code true} if the org.apache.logging.log4j.Marker has parent Markers
     */
    boolean hasParents();

    /**
     * Checks whether this org.apache.logging.log4j.Marker is an instance of the specified org.apache.logging.log4j.Marker.
     * 
     * @param m The org.apache.logging.log4j.Marker to check.
     * @return {@code true} if this org.apache.logging.log4j.Marker or one of its ancestors is the specified org.apache.logging.log4j.Marker, {@code false} otherwise.
     * @throws IllegalArgumentException if the argument is {@code null}
     */
    boolean isInstanceOf(Marker m);

    /**
     * Checks whether this org.apache.logging.log4j.Marker is an instance of the specified org.apache.logging.log4j.Marker.
     * 
     * @param name The name of the org.apache.logging.log4j.Marker.
     * @return {@code true} if this org.apache.logging.log4j.Marker or one of its ancestors matches the specified name, {@code false} otherwise.
     * @throws IllegalArgumentException if the argument is {@code null}
     */
    boolean isInstanceOf(String name);

    /**
     * Removes the specified org.apache.logging.log4j.Marker as a parent of this org.apache.logging.log4j.Marker.
     * 
     * @param marker The marker to remove.
     * @return {@code true} if the marker was removed.
     * @throws IllegalArgumentException if the argument is {@code null}
     */
    boolean remove(Marker marker);

    /**
     * Replaces the set of parent Markers with the provided Markers.
     * 
     * @param markers The new set of parent Markers or {@code null} to clear the parents.
     * @return The current org.apache.logging.log4j.Marker object.
     */
    Marker setParents(Marker... markers);
}
