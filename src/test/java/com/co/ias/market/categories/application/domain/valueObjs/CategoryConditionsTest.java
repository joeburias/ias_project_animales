package com.co.ias.market.categories.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CategoryConditionsTest {
    @Test
    @DisplayName("Null category conditions should throw an error")
    void null_category_conditions() {
        ArrayList<String> invalidCategoryConditions = null;
        assertThrows(NullPointerException.class, () -> {
            new CategoryConditions(invalidCategoryConditions);
        });
    }

    @Test
    @DisplayName("Valid category conditions should not throw an error")
    void valid_category_conditions() {
        ArrayList<String> invalidCategoryConditions = new ArrayList<>();
        invalidCategoryConditions.add("NEW");
        invalidCategoryConditions.add("COLLECTIBLE");
        assertDoesNotThrow(() -> {
            new CategoryConditions(invalidCategoryConditions);
        });
    }

    @Test
    @DisplayName("Invalid category conditions should throw an error")
    void invalid_category_conditions() {
        ArrayList<String> invalidCategoryConditions = new ArrayList<>();
        invalidCategoryConditions.add("INVALID");
        invalidCategoryConditions.add("DATA");
        assertThrows(IllegalArgumentException.class, () -> {
            new CategoryConditions(invalidCategoryConditions);
        });
    }

    @Test
    @DisplayName("Distinct category conditions so it has no repeated values")
    void repeated_category_conditions() {
        ArrayList<String> conditions = new ArrayList<>();
        conditions.add("NEW");
        conditions.add("COLLECTIBLE");
        conditions.add("COLLECTIBLE");
        CategoryConditions repeatedCategoryConditions = new CategoryConditions(conditions);

        ArrayList<String> conditions2 = new ArrayList<>();
        conditions2.add("NEW");
        conditions2.add("COLLECTIBLE");
        CategoryConditions correctCategoryConditions = new CategoryConditions(conditions2);

        assertEquals(correctCategoryConditions.toString(), repeatedCategoryConditions.toString());
    }
}