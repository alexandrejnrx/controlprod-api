package br.com.alexandrejnrx.controlprodapi.dto.product;

import jakarta.validation.constraints.NotBlank;

public record UpdateProducerNameDTO(
        @NotBlank(message = "O campo responsável não pode ser vazio.")
        String newProducerName
) {
}
