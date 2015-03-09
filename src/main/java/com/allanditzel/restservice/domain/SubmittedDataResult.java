package com.allanditzel.restservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

/**
 * Domain object representing the results of processed data.
 */
public class SubmittedDataResult {
    private Set<CategoryToSubcategoryMapping> categoryToSubcategoryMappings;
    private CategoriesCounter categoriesCount;

    @JsonCreator
    public SubmittedDataResult(@JsonProperty("category_to_subcategory") Set<CategoryToSubcategoryMapping> categoryToSubcategoryMappings,
                               @JsonProperty("category_counts") CategoriesCounter categoriesCount) {
        this.categoryToSubcategoryMappings = categoryToSubcategoryMappings;
        this.categoriesCount = categoriesCount;
    }

    public Set<CategoryToSubcategoryMapping> getCategoryToSubcategoryMappings() {
        return categoryToSubcategoryMappings;
    }

    public CategoriesCounter getCategoriesCount() {
        return categoriesCount;
    }
}
