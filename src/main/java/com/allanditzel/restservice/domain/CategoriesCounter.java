package com.allanditzel.restservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.LinkedHashMap;

/**
 * Domain object representing the count of various categories.
 */
public class CategoriesCounter extends LinkedHashMap<String, Integer> {

    @JsonCreator
    public CategoriesCounter() {
    }

    public void incrementCategoryCount(Category category) {
        if (!containsKey(category.getName().toUpperCase())) {
            put(category.getName().toUpperCase(), 1);
        } else {
            put(category.getName().toUpperCase(), get(category.getName().toUpperCase()) + 1);
        }
    }
}
