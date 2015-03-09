package com.allanditzel.restservice;

import com.allanditzel.restservice.domain.Category;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Main entry point for Rest Service application.
 */
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class RestService {

    /**
     * Naive implementation of available Categories. Using a Map to be able to look up categories quickly. We'll have to check existence of keys to guarantee we have no duplicates.
     *
     * @return a Map of categories
     */
    @Bean(name = "availableCategories")
    public Map<String, Category> availableCategories() {
        Map<String, Category> defaultCategories = Collections.synchronizedMap(new LinkedHashMap<String, Category>());

        Category person = new Category("PERSON");
        Category place = new Category("PLACE");
        Category animal = new Category("ANIMAL");
        Category computer = new Category("COMPUTER");
        Category other = new Category("OTHER");

        defaultCategories.put(person.getName(), person);
        defaultCategories.put(place.getName(), place);
        defaultCategories.put(animal.getName(), animal);
        defaultCategories.put(computer.getName(), computer);
        defaultCategories.put(other.getName(), other);

        return defaultCategories;
    }

	/**
	 * Kicks off Spring Context and starts up servlet container.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestService.class, args);
	}
}
