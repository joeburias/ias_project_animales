package com.co.ias.market.categories.application.ports.output;

import com.co.ias.market.categories.application.domain.Category;
import com.co.ias.market.categories.application.domain.valueObjs.CategoryId;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;

import java.util.Optional;

public interface CategoryRepository {
    void store(Category category);

    Optional<Category> get(CategoryId categoryId);

    void update(Category category);

    Boolean delete(CategoryId categoryId);
}
