package com.co.ias.market.categories.application.services;

import com.co.ias.market.categories.application.domain.Category;
import com.co.ias.market.categories.application.ports.input.UpdateCategoryUseCase;
import com.co.ias.market.categories.application.ports.output.CategoryRepository;
import com.co.ias.market.infranstructure.models.CategoryDTO;
import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.ports.input.UpdateProductUseCase;
import com.co.ias.market.products.application.ports.output.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCategoryService implements UpdateCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public UpdateCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDTO execute(CategoryDTO categoryDTO) {
        Category category = categoryDTO.toDomain();

        Optional<Category> productBD = categoryRepository.get(category.getId());

        if(productBD.isPresent()) {
            categoryRepository.update(category);
            categoryDTO.setStatus("Updated");
        } else {
            categoryDTO.setStatus("No Updated");
        }
        return categoryDTO;
    }
}
