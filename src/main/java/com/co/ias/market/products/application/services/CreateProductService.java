package com.co.ias.market.products.application.services;

import com.co.ias.market.categories.application.domain.Category;
import com.co.ias.market.categories.application.domain.valueObjs.CategoryId;
import com.co.ias.market.categories.application.ports.output.CategoryRepository;
import com.co.ias.market.infranstructure.models.CategoryDTO;
import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductCategory;
import com.co.ias.market.products.application.domain.valueObjs.ProductDescription;
import com.co.ias.market.products.application.domain.valueObjs.ProductName;
import com.co.ias.market.products.application.domain.valueObjs.ProductPrice;
import com.co.ias.market.products.application.ports.input.CreateProductsUseCase;
import com.co.ias.market.products.application.ports.output.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateProductService implements CreateProductsUseCase {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public CreateProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO execute(ProductDTO productDTO) {
        // Auth -- login
        // validation of domain
        // bussines rules
        Product productBD = productDTO.toDomain();
        CategoryId categoryId = new CategoryId(productBD.getCategory().getValue());
        Optional<Category> categoryBD = categoryRepository.get(categoryId);

        if(categoryBD.isPresent()) {
            Product product = new Product(null,
                    new ProductName(productDTO.getName()),
                    new ProductPrice(productDTO.getPrice()),
                    new ProductDescription(productDTO.getDescription()),
                    new ProductCategory(productDTO.getCategoryId()));

            ///logic store
            productRepository.store(product);
            productDTO.setStatus("Created");
        } else {
            productDTO.setStatus("Not Created because category doesn't exist.");
        }
        return productDTO;
    }
}
