package com.allanditzel.restservice.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for REST operations on
 */
@RestController
public class CategoriesResourceController {

	@RequestMapping("/categories")
	public String collectionsIndex() {
		return "Hello.";
	}
}
