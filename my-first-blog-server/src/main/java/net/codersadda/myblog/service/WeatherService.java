package net.codersadda.myblog.service;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.codersadda.myblog.entity.CurrentWeatherEntity;

@Component
public class WeatherService {
	@Resource
	private RestService genericService;
	
	@Resource
	private GenericEntity entity;
	
	@Value("${weather.api.key}")
	private String appKey;
	
	@Value("${weather.api.url}")
	private String apiUrl;
	
	@Value("${weather.api.id}")
	private String appId;
	
	@Resource
	private ObjectMapper mapper;
	
	
	public CurrentWeatherEntity currentWeather(double latitute, double longitude) throws JsonMappingException, JsonProcessingException {
		String url = StringUtils.join(apiUrl,"api/current/", latitute, ",", longitude,"?", "app_id=", appId, "&app_key=", appKey);
		String response = genericService.restCall(url, HttpMethod.GET, entity.getWeatherHeader(), String.class);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.reader().forType(CurrentWeatherEntity.class).readValue(response);
	}
}
