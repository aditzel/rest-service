package com.allanditzel.restservice.web.controller;

import com.allanditzel.restservice.domain.Category;
import com.allanditzel.restservice.manager.CategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Controller responsible for REST operations on {@link com.allanditzel.restservice.domain.Category}.
 */
@RestController
public class CategoriesResourceController {
    @Autowired
    private CategoryManager categoryManager;

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> collectionsIndex() {
		return Arrays.asList(categoryManager.getAvailableCategories().values().toArray(new Category[0]));
	}

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public @ResponseBody Category addCategory(@RequestBody Category category) {
        categoryManager.addCategory(new Category(category));
        return category;
    }
}
