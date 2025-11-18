package br.com.alexandrejnrx.controlprodapi.dto.project;

import jakarta.validation.constraints.NotNull;

public record UpdateActiveDTO(
        @NotNull(message = "O campo ativo não pode ser vazio.")
        Boolean newActive
) {
}
