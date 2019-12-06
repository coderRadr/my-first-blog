package net.codersadda.myblog.controller;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	private String ngPath="give angular dist folder path";

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
	

}
