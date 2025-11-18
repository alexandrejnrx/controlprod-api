package br.com.alexandrejnrx.controlprodapi.dto.client;

import jakarta.validation.constraints.NotBlank;

public record UpdateNameDTO(
        @NotBlank(message = "O campo nome não pode ser vazio.")
        String newName
) {
}
