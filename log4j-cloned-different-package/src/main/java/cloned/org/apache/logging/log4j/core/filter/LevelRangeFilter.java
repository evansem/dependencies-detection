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

/**
 * This filter returns the {@code onMatch} result if the level in the {@code LogEvent} is in the range of the configured
 * min and max levels, otherwise it returns {@code onMismatch} value . For example, if the filter is configured with
 * {@link Level#ERROR} and {@link Level#INFO} and the LogEvent contains {@link Level#WARN} then the onMatch value will
 * be returned since {@link Level#WARN WARN} events are in between {@link Level#ERROR ERROR} and {@link Level#INFO
 * INFO}.
 * <p>
 * The default Levels are both {@link Level#ERROR ERROR}.
 * </p>
 */
@Plugin(name = "LevelRangeFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE, printObject = true)
@PerformanceSensitive("allocation")
public final class LevelRangeFilter extends AbstractFilter {

    /**
     * Creates a ThresholdFilter.
     *
     * @param minLevel
     *            The minimum log org.apache.logging.log4j.Level.
     * @param maxLevel
     *            The maximum log org.apache.logging.log4j.Level.
     * @param match
     *            The action to take on a match.
     * @param mismatch
     *            The action to take on a mismatch.
     * @return The created ThresholdFilter.
     */
    // TODO Consider refactoring to use AbstractFilter.AbstractFilterBuilder
    @PluginFactory
    public static LevelRangeFilter createFilter(
            // @formatter:off
            @PluginAttribute("minLevel") final Level minLevel,
            @PluginAttribute("maxLevel") final Level maxLevel,
            @PluginAttribute("onMatch") final Filter.Result match,
            @PluginAttribute("onMismatch") final Filter.Result mismatch) {
            // @formatter:on
        final Level actualMinLevel = minLevel == null ? Level.ERROR : minLevel;
        final Level actualMaxLevel = maxLevel == null ? Level.ERROR : maxLevel;
        final Filter.Result onMatch = match == null ? Filter.Result.NEUTRAL : match;
        final Filter.Result onMismatch = mismatch == null ? Filter.Result.DENY : mismatch;
        return new LevelRangeFilter(actualMinLevel, actualMaxLevel, onMatch, onMismatch);
    }
    private final Level maxLevel;

    private final Level minLevel;

    private LevelRangeFilter(final Level minLevel, final Level maxLevel, final Filter.Result onMatch, final Filter.Result onMismatch) {
        super(onMatch, onMismatch);
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
    }

    private Filter.Result filter(final Level level) {
        return level.isInRange(this.minLevel, this.maxLevel) ? onMatch : onMismatch;
    }

    @Override
    public Filter.Result filter(final LogEvent event) {
        return filter(event.getLevel());
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final Message msg,
                                final Throwable t) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final Object msg,
                                final Throwable t) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object... params) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4, final Object p5) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4, final Object p5, final Object p6) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4, final Object p5, final Object p6,
                                final Object p7) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4, final Object p5, final Object p6,
                                final Object p7, final Object p8) {
        return filter(level);
    }

    @Override
    public Filter.Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                                final Object p0, final Object p1, final Object p2, final Object p3,
                                final Object p4, final Object p5, final Object p6,
                                final Object p7, final Object p8, final Object p9) {
        return filter(level);
    }

    public Level getMinLevel() {
        return minLevel;
    }

    @Override
    public String toString() {
        return minLevel.toString();
    }

}
