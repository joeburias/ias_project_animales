package com.co.ias.market.categories.application.services;

import com.co.ias.market.categories.application.domain.Category;
import com.co.ias.market.categories.application.domain.valueObjs.CategoryApproval;
import com.co.ias.market.categories.application.domain.valueObjs.CategoryDescription;
import com.co.ias.market.categories.application.domain.valueObjs.CategoryName;
import com.co.ias.market.categories.application.domain.valueObjs.CategoryPlace;
import com.co.ias.market.categories.application.ports.input.CreateCategoryUseCase;
import com.co.ias.market.categories.application.ports.output.CategoryRepository;
import com.co.ias.market.infranstructure.models.CategoryDTO;
import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductDescription;
import com.co.ias.market.products.application.domain.valueObjs.ProductName;
import com.co.ias.market.products.application.domain.valueObjs.ProductPrice;
import com.co.ias.market.products.application.ports.input.CreateProductsUseCase;
import com.co.ias.market.products.application.ports.output.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService implements CreateCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public CreateCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO execute(CategoryDTO categoryDTO) {
        // Auth -- login
        // validation of domain
        // bussines rules

        Category category = new Category(null,
                new CategoryName(categoryDTO.getName()),
                new CategoryDescription(categoryDTO.getDescription()),
                new CategoryPlace(categoryDTO.getPlace()),
                new CategoryApproval(categoryDTO.getApproval())
                );

        ///logic store
        categoryRepository.store(category);

        categoryDTO.setStatus("Created");
        return categoryDTO;
    }
}
