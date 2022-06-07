package com.co.ias.market.categories.application.domain;

import com.co.ias.market.categories.application.domain.valueObjs.*;

public class Category {
    private final CategoryId id;
    private final CategoryName name;
    private final CategoryDescription description;
    private final CategoryConditions conditions;
    private final CategoryPlace place;
    private final CategoryApproval approval;

    public Category(CategoryId id, CategoryName name, CategoryDescription description, CategoryConditions conditions,
                    CategoryPlace place, CategoryApproval approval) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.conditions = conditions;
        this.place = place;
        this.approval = approval;
    }

    public CategoryId getId() {
        return id;
    }

    public CategoryName getName() {
        return name;
    }

    public CategoryDescription getDescription() {
        return description;
    }

    public CategoryConditions getConditions() {
        return conditions;
    }

    public CategoryPlace getPlace() {
        return place;
    }

    public CategoryApproval getApproval() {
        return approval;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                ", conditions=" + conditions +
                ", place=" + place +
                ", approval=" + approval +
                '}';
    }
}
