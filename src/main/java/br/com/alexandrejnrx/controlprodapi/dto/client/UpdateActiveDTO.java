package br.com.alexandrejnrx.controlprodapi.dto.client;

import jakarta.validation.constraints.NotNull;

public record UpdateActiveDTO(
        @NotNull(message = "O campo ativo não pode ser vazio!")
        Boolean newActive
) {
}
