package net.codersadda.myblog.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import net.codersadda.myblog.exception.RequestException;

@Component
public class RestService {
	
	private Logger log = LogManager.getLogger(RestService.class);

	public <T> T restCall(String url, HttpMethod method, HttpHeaders headers, Class<T> responseClass) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> entity = new HttpEntity<>(headers);
		log.info("Entering rest service to make call to Url:: "+ url + ", method:: "+ method.toString());
		ResponseEntity<T> response = restTemplate.exchange(url, method, entity, responseClass);
		log.info("Leaving from rest service from call to Url:: "+ url + ", method:: "+ method.toString());
		return response.getBody();

	}

}
