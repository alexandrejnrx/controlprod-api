package br.com.alexandrejnrx.controlprodapi.dto.client;

import jakarta.validation.constraints.NotBlank;

public record UpdateNameDTO(
        @NotBlank
        String newName) {
}
