package com.co.ias.market.categories.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class CategoryId {
    final private Long value;

    public CategoryId(Long value) {
        Validate.notNull(value, "Category id can not be null.");
        Validate.isTrue(value.toString().length() <= 8,
                "Category id can not be longer than 8 characters.");
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
