package br.com.alexandrejnrx.controlprodapi.dto.product;

import jakarta.validation.constraints.NotBlank;

public record UpdateSerialNumberDTO(
        @NotBlank(message = "O campo serial não pode ser vazio.")
        Integer newSerialNumber
) {
}
