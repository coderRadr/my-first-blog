package net.codersadda.myblog.service;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestService {
	@Resource
	private GenericEntity genericSerice;

	public <T> T restCall(String url, HttpMethod method, Class<T> responseClass) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = genericSerice.getHeaders();
		HttpEntity<?> entity = new HttpEntity<>(headers);
		restTemplate.setErrorHandler(new ExceptionHandler());
		ResponseEntity<T> response = restTemplate.exchange(url, method, entity, responseClass);
		return response.getBody();

	}

}
