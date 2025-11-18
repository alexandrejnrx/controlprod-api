package br.com.alexandrejnrx.controlprodapi.dto.productType;

import jakarta.validation.constraints.NotBlank;

public record UpdateNameDTO(
        @NotBlank(message = "O campo nome, não pode ser vazio!")
        String newName
) {
}
