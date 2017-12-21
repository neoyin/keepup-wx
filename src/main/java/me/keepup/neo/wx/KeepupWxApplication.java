package me.keepup.neo.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
public class KeepupWxApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(KeepupWxApplication.class);
		//app.setWebEnvironment(true);
		app.run(args);
	}
}
