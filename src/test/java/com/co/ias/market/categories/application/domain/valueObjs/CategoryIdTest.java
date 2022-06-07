package com.co.ias.market.categories.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryIdTest {
    @Test
    @DisplayName("Null category id should throw an error")
    void null_category_id() {
        Long invalidCategoryId = null;
        assertThrows(NullPointerException.class, () -> {
            new CategoryId(invalidCategoryId);
        });
    }

    @Test
    @DisplayName("Valid category id should not throw an error")
    void valid_category_id() {
        Long validCategoryId = 666L;
        assertDoesNotThrow(() -> {
            new CategoryId(validCategoryId);
        });
    }

    @Test
    @DisplayName("Invalid category id should throw an error")
    void invalid_category_id() {
        Long invalidCategoryId = 10000000000000000L;
        assertThrows(IllegalArgumentException.class, () -> {
            new CategoryId(invalidCategoryId);
        });
    }
}