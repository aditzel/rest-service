package com.allanditzel.restservice.web.controller;

import com.allanditzel.restservice.domain.Category;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CategoryController {
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public HttpEntity<Category> getCategory(@PathVariable("id") String id) {
		Category category = new Category("PERSON");
		category.add(linkTo(methodOn(CategoryController.class).getCategory(id)).withSelfRel());

		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
}
