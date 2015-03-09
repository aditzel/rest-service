package com.allanditzel.restservice.manager;

import com.allanditzel.restservice.domain.Category;
import com.allanditzel.restservice.exception.ResourceAlreadyExistsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryManagerTest {
    private static final String UPPER_CASE_NAME = "UPPERCASE";
    @Mock
    private Map<String, Category> categoryMap;

    @InjectMocks
    private CategoryManager categoryManager;

    @Test
    public void shouldAddCategoryRegardlessOfCase() {
        when(categoryMap.containsKey(UPPER_CASE_NAME)).thenReturn(false);

        categoryManager.addCategory(new Category(UPPER_CASE_NAME.toLowerCase()));

        verify(categoryMap).containsKey(UPPER_CASE_NAME);
        verify(categoryMap).put(eq(UPPER_CASE_NAME), argThat(new ArgumentMatcher<Category>() {
            @Override
            public boolean matches(Object o) {
                Category category = (Category) o;
                return category.getName().equals(UPPER_CASE_NAME.toLowerCase());
            }
        }));
        verifyNoMoreInteractions(categoryMap);
    }

    @Test(expected = ResourceAlreadyExistsException.class)
    public void shouldRejectCategoryRegardlessOfCase() {
        when(categoryMap.containsKey(UPPER_CASE_NAME)).thenReturn(true);

        categoryManager.addCategory(new Category(UPPER_CASE_NAME.toLowerCase()));
    }
}