package com.co.ias.market.products.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ProductId {
    private final Long value;

    public ProductId(Long value) {
        Validate.notNull(value, "Product id can not be null");
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
