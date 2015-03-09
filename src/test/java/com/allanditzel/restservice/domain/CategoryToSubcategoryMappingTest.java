package com.allanditzel.restservice.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToSubcategoryMappingTest {
    @Test
    public void shouldEqual() {
        Category category1 = new Category("PERSON");
        Category category2 = new Category("PERSON");
        Subcategory subcategory1 = new Subcategory("Bob");
        Subcategory subcategory2 = new Subcategory("Bob");

        CategoryToSubcategoryMapping mapping1 = new CategoryToSubcategoryMapping(category1, subcategory1);
        CategoryToSubcategoryMapping mapping2 = new CategoryToSubcategoryMapping(category2, subcategory2);

        assertTrue(mapping1.equals(mapping2));
        assertTrue(mapping2.equals(mapping2));
    }

    @Test
    public void shouldNotEqual() {
        Category category1 = new Category("PERSON");
        Category category2 = new Category("PLACE");
        Subcategory subcategory1 = new Subcategory("Bob");
        Subcategory subcategory2 = new Subcategory("California");

        CategoryToSubcategoryMapping mapping1 = new CategoryToSubcategoryMapping(category1, subcategory1);
        CategoryToSubcategoryMapping mapping2 = new CategoryToSubcategoryMapping(category2, subcategory2);

        assertFalse(mapping1.equals(mapping2));
        assertFalse(mapping2.equals(mapping1));
    }
}