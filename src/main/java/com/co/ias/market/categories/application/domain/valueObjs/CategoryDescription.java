package com.co.ias.market.categories.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class CategoryDescription {
    final private String value;

    public CategoryDescription(String value) {
        Validate.notNull(value, "Category description can not be null.");
        Validate.isTrue(value.length() <= 40,
                "Category description can not be longer than 40 characters.");
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
