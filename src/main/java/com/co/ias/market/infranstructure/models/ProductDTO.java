package com.co.ias.market.infranstructure.models;

import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.*;

public class ProductDTO {
    private Long productId;
    private String name;
    private Integer price;
    private String description;
    private Long categoryId;
    private String status;

    public ProductDTO(Long productId, String name, Integer price, String description, Long categoryId) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Product toDomain() {
        return new Product(
                new ProductId(productId),
                new ProductName(name),
                new ProductPrice(price),
                new ProductDescription(description),
                new ProductCategory(categoryId));
    }

    public static ProductDTO fromDomain(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getId().getValue());
        productDTO.setName(product.getName().getValue());
        productDTO.setPrice(product.getPrice().getValue());
        productDTO.setDescription(product.getDescription().getValue());
        productDTO.setCategoryId(product.getCategory().getValue());
        return productDTO;
    }

    public ProductDTO() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
