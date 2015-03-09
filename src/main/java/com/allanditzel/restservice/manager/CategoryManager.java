package com.allanditzel.restservice.manager;

import com.allanditzel.restservice.domain.Category;
import com.allanditzel.restservice.exception.ResourceAlreadyExistsException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Manager responsible for business level operations on {@link com.allanditzel.restservice.domain.Category}s.
 */
@Component
public class CategoryManager {
    @Resource(name = "availableCategories")
    private Map<String, Category> availableCategories;

    public void addCategory(Category category) {
        if (!availableCategories.containsKey(category.getName().toUpperCase())) {
            availableCategories.put(category.getName().toUpperCase(), category);
        } else {
            throw new ResourceAlreadyExistsException("A category by that name already exists.");
        }
    }

    public Map<String, Category> getAvailableCategories() {
        return availableCategories;
    }

    public boolean isValidCategory(Category category) {
        return availableCategories.containsKey(category.getName().toUpperCase());
    }
}
