package com.co.ias.market.categories.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import java.util.Arrays;

public class CategoryApproval {
    final private String value;

    public CategoryApproval(String value) {
        Validate.notNull(value, "Category approval can not be null.");
        Validate.isTrue(Arrays.asList(new String[] { "YES", "N0" }).contains(value.toUpperCase().trim()),
                "Category approval must be a YES or NO string.");
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
