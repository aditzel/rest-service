package com.allanditzel.restservice.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesCounterTest {
    private static final String CATEGORY_NAME = "lowercase";

    private CategoriesCounter categoriesCounter;

    @Before
    public void setUp() {
        categoriesCounter = new CategoriesCounter();
    }

    @Test
    public void shouldInsertCountOfOne() {
        Category category = new Category(CATEGORY_NAME);
        categoriesCounter.incrementCategoryCount(category);
        assertEquals(new Integer(1), categoriesCounter.get(CATEGORY_NAME.toUpperCase()));
    }

    @Test
    public void shouldInsertCountOfThree() {
        Category category = new Category(CATEGORY_NAME);
        categoriesCounter.incrementCategoryCount(category);
        categoriesCounter.incrementCategoryCount(category);
        categoriesCounter.incrementCategoryCount(category);
        assertEquals(new Integer(3), categoriesCounter.get(CATEGORY_NAME.toUpperCase()));
    }
}