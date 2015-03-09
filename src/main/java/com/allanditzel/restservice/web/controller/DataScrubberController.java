package com.allanditzel.restservice.web.controller;

import com.allanditzel.restservice.domain.CategoriesCounter;
import com.allanditzel.restservice.domain.CategoryToSubcategoryMapping;
import com.allanditzel.restservice.domain.SubmittedData;
import com.allanditzel.restservice.domain.SubmittedDataResult;
import com.allanditzel.restservice.manager.CategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Controller responsible for taking in raw data from
 */
@RestController
public class DataScrubberController {
    @Autowired
    private CategoryManager categoryManager;

    @RequestMapping(value = "/dataScrubber", method = RequestMethod.POST)
    public @ResponseBody
    SubmittedDataResult scrubData(@RequestBody SubmittedData submittedData) {
        Set<CategoryToSubcategoryMapping> uniqueCategoriesToSubcategories = new LinkedHashSet<>();

        for (CategoryToSubcategoryMapping mapping : submittedData) {
            if (categoryManager.isValidCategory(mapping.getCategory())) {
                uniqueCategoriesToSubcategories.add(mapping);
            }
        }

        CategoriesCounter countData = new CategoriesCounter();

        for (CategoryToSubcategoryMapping mapping : uniqueCategoriesToSubcategories) {
            countData.incrementCategoryCount(mapping.getCategory());
        }

        return new SubmittedDataResult(uniqueCategoriesToSubcategories, countData);
    }
}
