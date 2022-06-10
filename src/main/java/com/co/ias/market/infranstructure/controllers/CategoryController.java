package com.co.ias.market.infranstructure.controllers;

import com.co.ias.market.categories.application.ports.input.CreateCategoryUseCase;
import com.co.ias.market.categories.application.ports.input.DeleteCategoryUseCase;
import com.co.ias.market.categories.application.ports.input.QueryCategoryByIdUseCase;
import com.co.ias.market.categories.application.ports.input.UpdateCategoryUseCase;
import com.co.ias.market.infranstructure.models.ApplicationError;
import com.co.ias.market.infranstructure.models.CategoryDTO;
import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.ports.input.CreateProductsUseCase;
import com.co.ias.market.products.application.ports.input.DeleteProductUseCase;
import com.co.ias.market.products.application.ports.input.QueryProductByIdUseCase;
import com.co.ias.market.products.application.ports.input.UpdateProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class CategoryController {
    private final CreateCategoryUseCase createCategoryUseCase;
    private final QueryCategoryByIdUseCase queryCategoryByIdUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;

    public CategoryController(CreateCategoryUseCase createCategoryUseCase,
                              QueryCategoryByIdUseCase queryCategoryByIdUseCase,
                              UpdateCategoryUseCase updateCategoryUseCase,
                              DeleteCategoryUseCase deleteCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.queryCategoryByIdUseCase = queryCategoryByIdUseCase;
        this.updateCategoryUseCase = updateCategoryUseCase;
        this.deleteCategoryUseCase = deleteCategoryUseCase;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            CategoryDTO categoryDTOOutput = createCategoryUseCase.execute(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTOOutput);
        } catch (NullPointerException | IllegalArgumentException e) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data",
                    Map.of("error", e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Long id) {
        try {
            Optional<CategoryDTO> categoryDTO = queryCategoryByIdUseCase.execute(id);
            if (categoryDTO.isPresent()) {
                return ResponseEntity.ok(categoryDTO.get());
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Category doesn't exist with this id");
            }
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }

    }

    @RequestMapping(value = "/categories", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCategorie(@RequestBody CategoryDTO categoryDTO) {
        try {
            CategoryDTO categoryDTOOutput = updateCategoryUseCase.execute(categoryDTO);
            return ResponseEntity.ok(categoryDTOOutput);
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value="/categories/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        try {
            Boolean result = deleteCategoryUseCase.execute(id);
            if (result) {
                return ResponseEntity.ok("Category deleted.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The category couldn't be deleted");
            }
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }
}
