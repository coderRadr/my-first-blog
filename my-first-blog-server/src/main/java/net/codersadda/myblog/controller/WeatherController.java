package net.codersadda.myblog.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.codersadda.myblog.entity.CurrentWeatherEntity;
import net.codersadda.myblog.service.WeatherService;

@RestController
@RequestMapping(path="/weather")
@Api(value="controller for Weather services")
public class WeatherController {
	@Resource
	private WeatherService service;
	
	@ApiOperation(value = "Get current location weather", response = CurrentWeatherEntity.class)
	@GetMapping(path="/current/latitude/{latitute}/longitude/{longitude}", produces=MediaType.APPLICATION_JSON_VALUE)
	public CurrentWeatherEntity currentWeather(@PathVariable(value = "latitute") double latitute, @PathVariable(value = "longitude") double longitude) throws JsonMappingException, JsonProcessingException {
		CurrentWeatherEntity response = service.currentWeather(latitute, longitude);
		response.setCityName(service.getLocationName(latitute, longitude));
		return response;
	}

}
 