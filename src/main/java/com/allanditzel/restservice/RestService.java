package com.allanditzel.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main entry point for Rest Service application.
 */
@EnableAutoConfiguration
@ComponentScan
public class RestService {
	/**
	 * Kicks off Spring Context and starts up servlet container.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestService.class, args);
	}
}
