/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.cdi;

import javax.inject.Inject;

import org.apache.camel.Endpoint;
import org.apache.camel.cdi.support.CamelEndpointInjectedBean;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;

/**
 * Test endpoint injection using vanilla camel annotations without the use of @Inject
 */
public class CamelEndpointInjectTest extends CdiTestSupport {

    @Inject
    private CamelEndpointInjectedBean bean;

    @Test
    public void shouldInjectEndpoint() {
        assertNotNull(bean);
        Endpoint endpoint = bean.getEndpoint();
        assertNotNull("Could not find injected endpoint!", endpoint);
        assertEquals("endpoint URI", "direct://inject", endpoint.getEndpointUri());

        MockEndpoint mockEndpoint = bean.getMockEndpoint();
        assertNotNull("Could not find injected mock endpoint!", mockEndpoint);
        assertEquals("mock endpoint URI", "mock://result", mockEndpoint.getEndpointUri());
    }

}
