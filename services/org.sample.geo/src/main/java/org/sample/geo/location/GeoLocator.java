/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sample.geo.location;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 * This is the Microservice resource class. See
 * <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/
 * wso2/msf4j#getting-started</a> for the usage of annotations.
 *
 * @since 1.0.0-SNAPSHOT
 */
@Path("/geolocation")
public class GeoLocator {
    //curl -X GET http://localhost:8082/geolocation/zipcode/1/2
	@GET
	@Path("/zipcode/{longitude}/{latitude}")
	@Produces({"application/json", "text/xml"})
	public Response zipcode(@PathParam("longitude") String longitude,@PathParam("latitude") String latitude) {
		// TODO: Implementation for HTTP GET request
		System.out.println("Geo locator service has been invoked");
		return Response.ok().entity(new Zipcode("US", "CA", "95321")).cookie(new NewCookie("longitude", longitude)).build();
				
	}

}