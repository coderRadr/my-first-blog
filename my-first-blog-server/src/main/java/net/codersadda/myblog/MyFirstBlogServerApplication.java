package net.codersadda.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan()
public class MyFirstBlogServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstBlogServerApplication.class, args);
	}
}
