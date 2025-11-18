package br.com.alexandrejnrx.controlprodapi.dto.product;

import br.com.alexandrejnrx.controlprodapi.model.ProductType;
import jakarta.validation.constraints.NotNull;

public record UpdateProductTypeDTO(
        @NotNull(message = "O campo tipo produto não pode ser vazio.")
        ProductType newProductType
) {
}
