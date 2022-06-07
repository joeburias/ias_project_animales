package com.co.ias.market.categories.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryPlaceTest {
    @Test
    @DisplayName("Null category place should throw an error")
    void null_category_place() {
        String invalidCategoryPlace = null;
        assertThrows(NullPointerException.class, () -> {
            new CategoryPlace(invalidCategoryPlace);
        });
    }

    @Test
    @DisplayName("Valid category place should not throw an error")
    void valid_category_place() {
        String validCategoryPlace = "AILE 40";
        assertDoesNotThrow(() -> {
            new CategoryPlace(validCategoryPlace);
        });
    }

    @Test
    @DisplayName("Invalid category place should throw an error")
    void invalid_category_place() {
        String invalidCategoryPlace = "This is the longest test description that you will EVER see soo... " +
                "yeah... don't worry if it shows too often please just ignore thiiiiiiiis!!! ";
        assertThrows(IllegalArgumentException.class, () -> {
            new CategoryPlace(invalidCategoryPlace);
        });
    }
}