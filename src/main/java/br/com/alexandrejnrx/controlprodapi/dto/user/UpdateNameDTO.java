package br.com.alexandrejnrx.controlprodapi.dto.user;

import jakarta.validation.constraints.NotBlank;

public record UpdateNameDTO(
        @NotBlank
        String newName
) {
}
