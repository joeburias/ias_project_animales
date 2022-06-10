package com.co.ias.market.categories.application.ports.input;

import com.co.ias.market.commons.UseCase;
import com.co.ias.market.infranstructure.models.CategoryDTO;
import com.co.ias.market.infranstructure.models.ProductDTO;

import java.util.Optional;

public interface QueryCategoryByIdUseCase extends UseCase<Long, Optional<CategoryDTO>> {
}
