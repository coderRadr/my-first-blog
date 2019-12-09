package net.codersadda.myblog.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@RestController
public class HomeController implements WebMvcConfigurer {
	
	private static final Logger log = LogManager.getLogger(HomeController.class);
	
	@Value("${ng-content}")
	private String ngPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("File:: "+ ngPath);
		registry.addResourceHandler("/viewContext/**").addResourceLocations(Paths.get(ngPath).toUri().toString()+"/my-first-blog-client/");
	}

	
	@GetMapping({"/","/login"})
	public void loadMainPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String baseUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		response.sendRedirect(baseUrl.concat("/viewContext/index.html"));
	}
	
	@GetMapping("/details")
	public List<String> getWebHeader(HttpServletRequest request, HttpServletResponse response) {
		log.info("starting Header details call: {}", request.getHeader("trackingId"));
		List<String> details = new ArrayList<>();
		details.add("Dashboard");
		details.add("News");
		details.add("Technology");
		details.add("Entertainment");
		details.add("Climate");
		details.add("Contact Us");
		return details;
	}
}
