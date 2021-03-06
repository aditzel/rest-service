package com.allanditzel.restservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain object representing a category.
 */
public class Category {
	private String name;

	@JsonCreator
	public Category(@JsonProperty("name") String name) {
		this.name = name;
	}

    public Category(Category category) {
        this.name = category.name.toUpperCase();
    }

	public String getName() {
		return name;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Category category = (Category) o;

        if (!name.equals(category.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
