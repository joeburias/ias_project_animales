package com.co.ias.market.categories.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryNameTest {
    @Test
    @DisplayName("Null category name should throw an error")
    void null_category_name() {
        String invalidCategoryName = null;
        assertThrows(NullPointerException.class, () -> {
            new CategoryName(invalidCategoryName);
        });
    }

    @Test
    @DisplayName("Valid category name should not throw an error")
    void valid_category_name() {
        String validCategoryName = "Headphones and headsets.";
        assertDoesNotThrow(() -> {
            new CategoryName(validCategoryName);
        });
    }

    @Test
    @DisplayName("Invalid category name should throw an error")
    void invalid_category_name() {
        String invalidCategoryName = "This is the longest test description that you will EVER see soo... " +
                "yeah... don't worry if it shows too often please just ignore thiiiiiiiis!!! ";
        assertThrows(IllegalArgumentException.class, () -> {
            new CategoryName(invalidCategoryName);
        });
    }
}