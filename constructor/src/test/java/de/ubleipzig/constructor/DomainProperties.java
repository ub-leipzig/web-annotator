/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.ubleipzig.constructor;

import java.io.InputStream;

/**
 * DomainProperties.
 *
 * @author christopher-johnson
 */
public abstract class DomainProperties {

    public static final String testResourceKey = "ubleipzig";

    public static final String testResources = "/testResources.json";

    public static String testResourceKey() {
        return testResourceKey;
    }

    public static final String testContext = "/p2context.json";

    public static InputStream context() {
        return DomainProperties.class.getResourceAsStream(testContext);
    }

    public static final String testDomain = "https://iiif.ub.uni-leipzig.de";

    public static final String fileResource = "/testIIIFGraph.n3";

    public String domain() {
        return testDomain;
    }

    public String fileResource() {
        return fileResource;
    }
}