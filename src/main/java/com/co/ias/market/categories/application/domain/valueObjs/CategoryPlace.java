package com.co.ias.market.categories.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class CategoryPlace {
    final private String value;

    public CategoryPlace(String value) {
        Validate.notNull(value, "Category place can not be null.");
        Validate.isTrue(value.length() <= 40, "Category place can not be longer than 40 characters.");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
