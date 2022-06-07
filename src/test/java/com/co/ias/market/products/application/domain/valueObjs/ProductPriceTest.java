package com.co.ias.market.products.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductPriceTest {
    @Test
    @DisplayName("Null product price should throw an error")
    void null_product_price() {
        // AAA - arrange act assert
        Integer invalidPrice = null;

        assertThrows(NullPointerException.class, () -> {
            new ProductPrice(invalidPrice);
        });

    }

    @Test
    @DisplayName("valid product price should not throw an error")
    void valid_product_price() {
        // AAA - arrange act assert
        Integer validPrice = 100;

        assertDoesNotThrow(() -> {
            new ProductPrice(validPrice);
        });

    }

}
