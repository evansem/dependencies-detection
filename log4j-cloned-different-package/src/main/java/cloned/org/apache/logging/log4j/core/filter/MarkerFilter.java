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
package cloned.org.apache.logging.log4j.core.filter;

import cloned.org.apache.logging.log4j.Level;
import cloned.org.apache.logging.log4j.Marker;
import cloned.org.apache.logging.log4j.core.Filter;
import cloned.org.apache.logging.log4j.core.LogEvent;
import cloned.org.apache.logging.log4j.core.Logger;
import cloned.org.apache.logging.log4j.core.config.Node;
import cloned.org.apache.logging.log4j.core.config.plugins.Plugin;
import cloned.org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import cloned.org.apache.logging.log4j.core.config.plugins.PluginFactory;
import cloned.org.apache.logging.log4j.message.Message;
import cloned.org.apache.logging.log4j.util.PerformanceSensitive;
import cloned.org.apache.logging.log4j.core.AbstractLifeCycle;

/**
 * This filter returns the onMatch result if the marker in the LogEvent is the same as or has the
 * configured marker as a parent.
 */
@Plugin(name = "MarkerFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE, printObject = true)
@PerformanceSensitive("allocation")
public final class MarkerFilter extends AbstractFilter {

    public static final String ATTR_MARKER = "marker";
    private final String name;

    private MarkerFilter(final String name, final Filter.Result onMatch, final Filter.Result onMismatch) {
        super(onMatch, onMismatch);
        this.name = name;
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object... params) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final Object msg,
                                final Throwable t) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final Message msg,
                                final Throwable t) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final LogEvent event) {
        return filter(event.getMarker());
    }

    private Filter.Result filter(final Marker marker) {
        return marker != null && marker.isInstanceOf(name) ? onMatch : onMismatch;
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4, final Object p5) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4, final Object p5, final Object p6) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4, final Object p5, final Object p6,
                                final Object p7) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4, final Object p5, final Object p6,
                                final Object p7, final Object p8) {
        return filter(marker);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4, final Object p5, final Object p6,
                                final Object p7, final Object p8, final Object p9) {
        return filter(marker);
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Creates the MarkerFilter.
     * @param marker The org.apache.logging.log4j.Marker name to match.
     * @param match The action to take if a match occurs.
     * @param mismatch The action to take if no match occurs.
     * @return A MarkerFilter.
     */
    // TODO Consider refactoring to use AbstractFilter.AbstractFilterBuilder
    @PluginFactory
    public static MarkerFilter createFilter(
            @PluginAttribute(ATTR_MARKER) final String marker,
            @PluginAttribute(AbstractFilterBuilder.ATTR_ON_MATCH) final Filter.Result match,
            @PluginAttribute(AbstractFilterBuilder.ATTR_ON_MISMATCH) final Filter.Result mismatch) {

        if (marker == null) {
            AbstractLifeCycle.LOGGER.error("A marker must be provided for MarkerFilter");
            return null;
        }
        return new MarkerFilter(marker, match, mismatch);
    }

}
