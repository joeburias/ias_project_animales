package com.co.ias.market.products.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;

public class ProductPrice {
    private final Integer value;

    public ProductPrice(Integer value) {
        Validate.notNull(value, "Product price can not be null");
        Validate.isTrue(value.toString().length() <= 8, "Product price can not be longer than 8 characters");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
