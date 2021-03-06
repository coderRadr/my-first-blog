package net.codersadda.myblog.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.codersadda.myblog.entity.Model;

@EnableWebMvc
@Configuration
@RestController
public class HomeController implements WebMvcConfigurer {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Value("${ng-content}")
	private String ngPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(Paths.get(ngPath).toUri().toString()+"/my-first-blog-client/");
	}

	
	@GetMapping({"/","/login"})
	public void loadMainPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String baseUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		response.sendRedirect(baseUrl.concat("/index.html"));
	}
	
	@GetMapping("/details")
	public List<Model> getWebHeader(HttpServletRequest request, HttpServletResponse response) {
		List<Model> details = new ArrayList<>();
		if(log.isDebugEnabled()) {
			log.info("starting Header details call: {}", request.getHeader("trackingId"));
		}
		details.add(new Model("Dashboard", "dashboard"));
		details.add(new Model("News", "news"));
		details.add(new Model("Technology", "tech"));
		details.add(new Model("Entertainment", "ent"));
		details.add(new Model("Climate", "climate"));
		details.add(new Model("Contact Us", "contact"));
		return details;
	}
}
