package com.allanditzel.restservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 */
@Configuration
@Import({
		WebConfiguration.class
})
@ComponentScan
public class ApplicationConfig {
}
