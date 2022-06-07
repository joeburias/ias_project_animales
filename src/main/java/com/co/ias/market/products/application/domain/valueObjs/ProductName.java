package com.co.ias.market.products.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ProductName {
    private final String value;

    public ProductName(String value) {
        Validate.notNull(value, "Product name can not be null");
        Validate.isTrue(value.length() <= 20, "Product name can not be longer than 20 characters");
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }
}
