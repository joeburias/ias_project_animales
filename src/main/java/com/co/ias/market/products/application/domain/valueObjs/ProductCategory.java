package com.co.ias.market.products.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ProductCategory {
    private final Long value;

    public ProductCategory(Long value) {
        Validate.notNull(value, "Product category id can not be null");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
