package com.co.ias.market.products.application.services;

import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductDescription;
import com.co.ias.market.products.application.domain.valueObjs.ProductName;
import com.co.ias.market.products.application.domain.valueObjs.ProductPrice;
import com.co.ias.market.products.application.ports.input.CreateProductsUseCase;
import com.co.ias.market.products.application.ports.output.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase implements CreateProductsUseCase {

    private final ProductRepository productRepository;

    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO execute(ProductDTO productDTO) {
        // Auth -- login info
        // Validation of domain
        // business rules

        Product product = new Product(null,
                new ProductName(productDTO.getName()),
                new ProductPrice(productDTO.getPrice()),
                new ProductDescription(productDTO.getDescription()));

        productRepository.store(product);

        return productDTO;
    }
}
