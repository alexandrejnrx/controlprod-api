package br.com.alexandrejnrx.controlprodapi.dto.product;

import jakarta.validation.constraints.NotBlank;

public record UpdateNup(
        @NotBlank(message = "O campo NUP não pode ser vazio.")
        Integer newNup
) {
}
