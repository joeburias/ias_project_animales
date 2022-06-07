package com.co.ias.market.categories.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class CategoryConditions {
    final private ArrayList<String> value;
    final private String[] expectedValues = {"NEW", "RENEWED", "RENTAL", "USED", "COLLECTIBLE"};

    public CategoryConditions(ArrayList<String> value) {
        Validate.notNull(value, "Category conditions can not be null.");
        Validate.isTrue(!Collections.disjoint(Arrays.stream(expectedValues).collect(Collectors
                        .toCollection(ArrayList::new)), value),
                "Category conditions has to be NEW, RENEWED, RENTAL, USED and/or COLLECTIBLE.");
        this.value = value.stream().distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
