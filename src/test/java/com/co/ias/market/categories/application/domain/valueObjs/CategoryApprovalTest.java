package com.co.ias.market.categories.application.domain.valueObjs;

import com.co.ias.market.products.application.domain.valueObjs.ProductPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryApprovalTest {
    @Test
    @DisplayName("Null category approval should throw an error")
    void null_category_approval() {
        String invalidCategoryApproval = null;
        assertThrows(NullPointerException.class, () -> {
            new CategoryApproval(invalidCategoryApproval);
        });
    }

    @Test
    @DisplayName("Valid category approval should not throw an error")
    void valid_category_approval() {
        String validCategoryApproval = "YES";
        assertDoesNotThrow(() -> {
            new CategoryApproval(validCategoryApproval);
        });
    }

    @Test
    @DisplayName("Invalid category approval should throw an error")
    void invalid_category_approval() {
        String invalidCategoryApproval = "YESNOO ";
        assertThrows(IllegalArgumentException.class, () -> {
            new CategoryApproval(invalidCategoryApproval);
        });
    }
}