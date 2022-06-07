package com.co.ias.market.categories.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDescriptionTest {
    @Test
    @DisplayName("Null category description should throw an error")
    void null_category_description() {
        String invalidCategoryDescription = null;
        assertThrows(NullPointerException.class, () -> {
            new CategoryDescription(invalidCategoryDescription);
        });
    }

    @Test
    @DisplayName("Valid category description should not throw an error")
    void valid_category_description() {
        String validCategoryDescription = "This is a test description. Well done!";
        assertDoesNotThrow(() -> {
            new CategoryDescription(validCategoryDescription);
        });
    }

    @Test
    @DisplayName("Invalid category description should throw an error")
    void invalid_category_description() {
        String invalidCategoryDescription = "This is the longest test description that you will EVER see soo... " +
                "yeah... don't worry if it shows too often please just ignore thiiiiiiiis!!! ";
        assertThrows(IllegalArgumentException.class, () -> {
            new CategoryDescription(invalidCategoryDescription);
        });
    }
}