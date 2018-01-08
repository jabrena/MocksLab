/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.hateoas.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import sample.hateoas.domain.Info;

@Controller
public class InfoController {

	/* OR
	@Value("${pivotalAddress}")
	private String endpoint;
	*/

	private String endpoint ;

	private final EntityLinks entityLinks;

	public InfoController(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
		this.endpoint = "http://api.run.pivotal.io/v2/info";
	}


	public String getEndpoint() {
		return endpoint;
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<Info> getInfo() {
		RestTemplate restTemplate = new RestTemplate();
		Info info = restTemplate.getForObject(this.getEndpoint(), Info.class);
		Resource<Info> resource = new Resource<Info>(info);
		return resource;
	}

}
