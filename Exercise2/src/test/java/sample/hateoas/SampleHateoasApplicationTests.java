/*
 * Copyright 2012-2016 the original author or authors.
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

package sample.hateoas;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SampleHateoasApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void hasHalLinks() throws Exception {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/info",
				String.class);
		//assertThat(entity.getStatusCode()).isEqualTo(HttpMethod.GET);
		System.out.print(entity.getBody());
		assertThat(entity.getBody()).startsWith(
				"{\"name");
		//assertThat(entity.getBody()).contains("_links\":{\"self\":{\"href\"");

	}

	@Test
	public void producesJsonWhenXmlIsPreferred() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, "application/xml;q=0.9,application/json;q=0.8");
		HttpEntity<?> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = this.restTemplate.exchange("/info",
				HttpMethod.GET, request, String.class);
		//assertThat(response.getStatusCode()).isEqualTo(HttpStatus.GET);
		assertThat(response.getHeaders().getContentType())
				.isEqualTo(MediaType.parseMediaType("application/json;charset=UTF-8"));
	}

}
