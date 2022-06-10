package com.co.ias.market.infranstructure.models;

import com.co.ias.market.categories.application.domain.Category;
import com.co.ias.market.categories.application.domain.valueObjs.*;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductDescription;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import com.co.ias.market.products.application.domain.valueObjs.ProductName;
import com.co.ias.market.products.application.domain.valueObjs.ProductPrice;

public class CategoryDTO {
    private Long categoryId;
    private String name;
    private String description;
    private String place;
    private String approval;

    private String status;

    public CategoryDTO(Long categoryId, String name, String description, String place, String approval) {
        this.categoryId = categoryId;
        this.name = name;
        this.place = place;
        this.description = description;
        this.approval = approval;
    }

    public CategoryDTO() {
    }
    public Category toDomain() {
        return new Category(
                new CategoryId(categoryId),
                new CategoryName(name),
                new CategoryDescription(description),
                new CategoryPlace(place),
                new CategoryApproval(approval)
        );
    }

    public static CategoryDTO fromDomain(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getId().getValue());
        categoryDTO.setName(category.getName().getValue());
        categoryDTO.setPlace(category.getPlace().getValue());
        categoryDTO.setDescription(category.getDescription().getValue());
        categoryDTO.setApproval(category.getApproval().getValue());
        return categoryDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", place='" + place + '\'' +
                ", approval='" + approval + '\'' +
                '}';
    }
}
