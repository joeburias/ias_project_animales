package com.co.ias.market.categories.application.services;

import com.co.ias.market.categories.application.domain.Category;
import com.co.ias.market.categories.application.domain.valueObjs.CategoryId;
import com.co.ias.market.categories.application.ports.input.DeleteCategoryUseCase;
import com.co.ias.market.categories.application.ports.output.CategoryRepository;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteCategoryService implements DeleteCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public DeleteCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Boolean execute(Long id) {
        CategoryId categoryId = new CategoryId(id);

        Optional<Category> category = categoryRepository.get(categoryId);

        if (category.isPresent()) {
            categoryRepository.delete(categoryId);
        }

        return category.isPresent();
    }
}
