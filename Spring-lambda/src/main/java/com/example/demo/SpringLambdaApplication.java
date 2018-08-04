package com.example.demo;

import javax.ws.rs.core.Application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringLambdaApplication extends SpringBootServletInitializer {

	// silence console logging
	@Value("${logging.level.root:OFF}")
	String message = "";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}