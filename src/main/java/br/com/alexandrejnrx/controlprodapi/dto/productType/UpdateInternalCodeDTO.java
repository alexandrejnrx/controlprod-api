package br.com.alexandrejnrx.controlprodapi.dto.productType;

import jakarta.validation.constraints.NotBlank;

public record UpdateInternalCodeDTO(
        @NotBlank(message = "O campo código, não pode ser vazio.")
        String newInternalCode) {
}
