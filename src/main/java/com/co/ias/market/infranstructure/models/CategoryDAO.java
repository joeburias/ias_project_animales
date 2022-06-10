package com.co.ias.market.infranstructure.models;

import com.co.ias.market.categories.application.domain.Category;
import com.co.ias.market.categories.application.domain.valueObjs.*;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductDescription;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import com.co.ias.market.products.application.domain.valueObjs.ProductName;
import com.co.ias.market.products.application.domain.valueObjs.ProductPrice;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO {
    private Long id;
    private String name;
    private String description;
    private String place;
    private String approval;

    public CategoryDAO(Long id, String name, String description, String place, String approval) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.approval = approval;
    }

    public CategoryDAO() {
    }

    public Category toDomain() {
        return new Category(
                new CategoryId(id),
                new CategoryName(name),
                new CategoryDescription(description),
                new CategoryPlace(place),
                new CategoryApproval(approval)
        );
    }

    public static CategoryDAO fromDomain(Category category) {
        CategoryDAO categoryDAO = new CategoryDAO(
                category.getId().getValue(),
                category.getName().getValue(),
                category.getDescription().getValue(),
                category.getPlace().getValue(),
                category.getApproval().getValue()
        );
        return categoryDAO;
    }

    public static CategoryDAO fromResultSet(ResultSet resultSet) throws SQLException {
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.setId(resultSet.getLong("id"));
        categoryDAO.setName(resultSet.getString("name"));
        categoryDAO.setDescription(resultSet.getString("description"));
        categoryDAO.setApproval(resultSet.getString("approval"));
        categoryDAO.setPlace(resultSet.getString("place"));
        return categoryDAO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
