package com.allanditzel.restservice.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubcategoryTest {
    @Test
    public void shouldEqual() {
        Subcategory subcategory1 = new Subcategory("Bob");
        Subcategory subcategory2 = new Subcategory("Bob");

        assertTrue(subcategory1.equals(subcategory2));
        assertTrue(subcategory2.equals(subcategory1));
    }

    @Test
    public void shouldNotEqual() {
        Subcategory subcategory1 = new Subcategory("Bob");
        Subcategory subcategory2 = new Subcategory("Mary");

        assertFalse(subcategory1.equals(subcategory2));
        assertFalse(subcategory2.equals(subcategory1));
    }
}