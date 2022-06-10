package com.co.ias.market.infranstructure.models;

import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
    private Long id;
    private String name;
    private Integer price;
    private String description;
    private Long categoryId;

    public ProductDAO(Long id, String name, Integer price, String description, Long categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public ProductDAO() {
    }

    public Product toDomain() {
        return new Product(
                new ProductId(id),
                new ProductName(name),
                new ProductPrice(price),
                new ProductDescription(description),
                new ProductCategory(categoryId));
    }

    public static ProductDAO fromDomain(Product product) {
        ProductDAO productDAO = new ProductDAO(
                product.getId().getValue(),
                product.getName().getValue(),
                product.getPrice().getValue(),
                product.getDescription().getValue(),
                product.getCategory().getValue());
        return productDAO;
    }

    public static ProductDAO fromResultSet(ResultSet resultSet) throws SQLException {
        ProductDAO productDAO = new ProductDAO();
        productDAO.setId(resultSet.getLong("id"));
        productDAO.setName(resultSet.getString("name"));
        productDAO.setPrice(resultSet.getInt("price"));
        productDAO.setDescription(resultSet.getString("description"));
        productDAO.setCategoryId(resultSet.getLong("category"));
        return productDAO;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
