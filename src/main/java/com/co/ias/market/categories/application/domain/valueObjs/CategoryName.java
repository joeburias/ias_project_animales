package com.co.ias.market.categories.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class CategoryName {
    final private String value;

    public CategoryName(String value) {
        Validate.notNull(value, "Category name can not be null.");
        Validate.isTrue(value.length() <= 40, "Category name can not be longer than 40 characters.");
        this.value = value;
    }

    public String getName() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
