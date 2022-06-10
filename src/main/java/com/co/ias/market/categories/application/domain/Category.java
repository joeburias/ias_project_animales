package com.co.ias.market.categories.application.domain;

import com.co.ias.market.categories.application.domain.valueObjs.*;

public class Category {
    private final CategoryId id;
    private final CategoryName name;
    private final CategoryDescription description;
    private final CategoryPlace place;
    private final CategoryApproval approval;

    public Category(CategoryId id, CategoryName name, CategoryDescription description,
                    CategoryPlace place, CategoryApproval approval) {
        this.id = id;
        this.name = name;
        this.description = description;
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
                ", place=" + place +
                ", approval=" + approval +
                '}';
    }
}
