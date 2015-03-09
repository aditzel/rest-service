package com.allanditzel.restservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain object that maps categories to subcategories.
 */
public class CategoryToSubcategoryMapping {
    private Category category;
    private Subcategory subcategory;

    @JsonCreator
    public CategoryToSubcategoryMapping(@JsonProperty("category") Category category, @JsonProperty("subcategory") Subcategory subcategory) {
        this.category = category;
        this.subcategory = subcategory;
    }

    public Category getCategory() {
        return category;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CategoryToSubcategoryMapping mapping = (CategoryToSubcategoryMapping) o;

        if (!category.equals(mapping.category)) {
            return false;
        }

        if (!subcategory.equals(mapping.subcategory)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + subcategory.hashCode();
        return result;
    }
}
