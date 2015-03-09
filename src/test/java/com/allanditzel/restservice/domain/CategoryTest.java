package com.allanditzel.restservice.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {
    @Test
    public void shouldEqual() {
        Category category1 = new Category("PERSON");
        Category category2 = new Category("PERSON");

        assertTrue(category1.equals(category2));
        assertTrue(category2.equals(category1));
    }

    @Test
    public void shoutNotEqual() {
        Category category1 = new Category("PERSON");
        Category category2 = new Category("PLACE");

        assertFalse(category1.equals(category2));
        assertFalse(category2.equals(category1));
    }
}