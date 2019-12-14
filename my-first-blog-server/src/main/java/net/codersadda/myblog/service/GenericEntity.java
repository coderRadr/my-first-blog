package net.codersadda.myblog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class GenericEntity {
	
	@Value("${news.newsApiOrg.ApiKey}")
	private String apiKey;
	
	public HttpHeaders getNewsHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "application/json");
	    headers.add("Authorization", "Bearer "+apiKey );
		return headers;
	}
	
	public HttpHeaders getWeatherHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return headers;
	}

}
