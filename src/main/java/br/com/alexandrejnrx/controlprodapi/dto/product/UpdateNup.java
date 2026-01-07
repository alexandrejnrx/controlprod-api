package br.com.alexandrejnrx.controlprodapi.dto.product;

import jakarta.validation.constraints.NotNull;

public record UpdateNup(
        @NotNull(message = "O campo NUP não pode ser vazio.")
        Integer newNup
) {
}
