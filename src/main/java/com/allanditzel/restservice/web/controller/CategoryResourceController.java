package com.allanditzel.restservice.web.controller;

import com.allanditzel.restservice.domain.Category;
import com.allanditzel.restservice.exception.ResourceNotFoundException;
import com.allanditzel.restservice.manager.CategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryResourceController {
    @Autowired
    private CategoryManager categoryManager;

	@RequestMapping(value = "/categories/{name}", method = RequestMethod.GET)
	public @ResponseBody Category getCategory(@PathVariable("name") String name) {

        Category category = categoryManager.getAvailableCategories().get(name.toUpperCase());

        if (category == null) {
            throw new ResourceNotFoundException(String.format("The category '%s' cannot be found.", name));
        }

		return category;
	}
}
