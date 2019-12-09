package net.codersadda.myblog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.codersadda.myblog.entity.ContactDetails;
import net.codersadda.myblog.entity.NewsResponse;
import net.codersadda.myblog.service.ContactService;
import net.codersadda.myblog.service.CryptoService;

@RestController
@RequestMapping(path="/data")
@Api(value="Generic data retrieval Controller")
public class DataController {
	
	@Resource
	private CryptoService cryptoService;
	
	@Resource
	private ContactService service;
	
	@ApiOperation(value = "Get ", response = String.class)
	@GetMapping(path="/cryptoNews", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<NewsResponse> getCryptoNews() {
		return cryptoService.getCryptoNews();
	}
	
	@ApiOperation(value = "Get ", response = String.class)
	@GetMapping(path="/contact", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ContactDetails> getContact() {
		return service.getDeveloperDetails();
	}

}
