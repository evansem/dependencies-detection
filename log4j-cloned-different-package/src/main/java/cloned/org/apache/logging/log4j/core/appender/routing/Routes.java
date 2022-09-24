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
package cloned.org.apache.logging.log4j.core.appender.routing;

import static cloned.org.apache.logging.log4j.core.appender.routing.RoutingAppender.STATIC_VARIABLES_KEY;

import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

import javax.script.Bindings;

import cloned.org.apache.logging.log4j.Logger;
import cloned.org.apache.logging.log4j.core.Core;
import cloned.org.apache.logging.log4j.core.LogEvent;
import cloned.org.apache.logging.log4j.core.config.Configuration;
import cloned.org.apache.logging.log4j.core.config.plugins.Plugin;
import cloned.org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import cloned.org.apache.logging.log4j.core.config.plugins.PluginBuilderFactory;
import cloned.org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import cloned.org.apache.logging.log4j.core.config.plugins.PluginElement;
import cloned.org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import cloned.org.apache.logging.log4j.core.script.AbstractScript;
import cloned.org.apache.logging.log4j.core.script.ScriptManager;
import cloned.org.apache.logging.log4j.status.StatusLogger;

/**
 * Contains the individual Route elements.
 */
@Plugin(name = "Routes", category = Core.CATEGORY_NAME, printObject = true)
public final class Routes {

    private static final String LOG_EVENT_KEY = "logEvent";

    public static class Builder implements cloned.org.apache.logging.log4j.core.util.Builder<Routes> {

        @PluginConfiguration
        private Configuration configuration;

        @PluginAttribute("pattern")
        private String pattern;

        @PluginElement("Script")
        private AbstractScript patternScript;

        @PluginElement("Routes")
        @Required
        private Route[] routes;

        @Override
        public Routes build() {
            if (routes == null || routes.length == 0) {
                LOGGER.error("No Routes configured.");
                return null;
            }
            if ((patternScript != null && pattern != null) || (patternScript == null && pattern == null)) {
                LOGGER.warn("In a Routes element, you must configure either a Script element or a pattern attribute.");
            }
            if (patternScript != null) {
                if (configuration == null) {
                    LOGGER.error("No Configuration defined for Routes; required for Script");
                } else {
                    configuration.getScriptManager().addScript(patternScript);
                }
            }
            return new Routes(configuration, patternScript, pattern, routes);
        }

        public Configuration getConfiguration() {
            return configuration;
        }

        public String getPattern() {
            return pattern;
        }

        public AbstractScript getPatternScript() {
            return patternScript;
        }

        public Route[] getRoutes() {
            return routes;
        }

        public Builder withConfiguration(@SuppressWarnings("hiding") final Configuration configuration) {
            this.configuration = configuration;
            return this;
        }

        public Builder withPattern(@SuppressWarnings("hiding") final String pattern) {
            this.pattern = pattern;
            return this;
        }

        public Builder withPatternScript(@SuppressWarnings("hiding") final AbstractScript patternScript) {
            this.patternScript = patternScript;
            return this;
        }

        public Builder withRoutes(@SuppressWarnings("hiding") final Route[] routes) {
            this.routes = routes;
            return this;
        }

    }

    private static final Logger LOGGER = StatusLogger.getLogger();

    /**
     * Creates the Routes.
     * @param pattern The pattern.
     * @param routes An array of Route elements.
     * @return The Routes container.
     * @deprecated since 2.7; use {@link #newBuilder()}.
     */
    @Deprecated
    public static Routes createRoutes(
            final String pattern,
            final Route... routes) {
        if (routes == null || routes.length == 0) {
            LOGGER.error("No routes configured");
            return null;
        }
        return new Routes(null, null, pattern, routes);
    }

    @PluginBuilderFactory
    public static Builder newBuilder() {
        return new Builder();
    }

    private final Configuration configuration;

    private final String pattern;

    private final AbstractScript patternScript;

    // TODO Why not make this a Map or add a Map.
    private final Route[] routes;

    private Routes(final Configuration configuration, final AbstractScript patternScript, final String pattern, final Route... routes) {
        this.configuration = configuration;
        this.patternScript = patternScript;
        this.pattern = pattern;
        this.routes = routes;
    }

    /**
     * Returns the pattern.
     * @param event The log event passed to the script (if there is a script.)
     * @param scriptStaticVariables The script's static variables.
     * @return the pattern.
     */
    public String getPattern(final LogEvent event, final ConcurrentMap<Object, Object> scriptStaticVariables) {
        if (patternScript != null) {
            final ScriptManager scriptManager = configuration.getScriptManager();
            final Bindings bindings = scriptManager.createBindings(patternScript);
            bindings.put(STATIC_VARIABLES_KEY, scriptStaticVariables);
            bindings.put(LOG_EVENT_KEY, event);
            final Object object = scriptManager.execute(patternScript.getName(), bindings);
            bindings.remove(LOG_EVENT_KEY);
            return Objects.toString(object, null);
        }
        return pattern;
    }

    /**
     * Gets the optional script that decides which route to pick.
     * @return the optional script that decides which route to pick. May be null.
     */
    public AbstractScript getPatternScript() {
        return patternScript;
    }

    public Route getRoute(final String key) {
        for (final Route route : routes) {
            if (Objects.equals(route.getKey(), key)) {
                return route;
            }
        }
        return null;
    }

    /**
     * Returns the array of Route elements.
     * @return an array of Route elements.
     */
    public Route[] getRoutes() {
        return routes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (final Route route : routes) {
            if (!first) {
                sb.append(',');
            }
            first = false;
            sb.append(route.toString());
        }
        sb.append('}');
        return sb.toString();

    }

}
