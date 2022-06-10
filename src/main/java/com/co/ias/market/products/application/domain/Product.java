package com.co.ias.market.products.application.domain;

import com.co.ias.market.products.application.domain.valueObjs.*;

public class Product {
    private final ProductId id;
    private final ProductName name;
    private final ProductPrice price;
    private final ProductDescription description;
    private final ProductCategory category;


    public Product(ProductId id, ProductName name, ProductPrice price, ProductDescription description,
                   ProductCategory category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.description = description;
            this.category = category;
    }

    public ProductId getId() {
        return id;
    }

    public ProductName getName() {
        return name;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public ProductDescription getDescription() {
        return description;
    }

    public ProductCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", description=" + description +
                ", category=" + category +
                '}';
    }
}
