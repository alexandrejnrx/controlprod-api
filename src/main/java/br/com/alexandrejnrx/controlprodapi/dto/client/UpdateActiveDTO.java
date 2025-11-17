package br.com.alexandrejnrx.controlprodapi.dto.client;

import jakarta.validation.constraints.NotNull;

public record UpdateActiveDTO(
        @NotNull
        Boolean newActive
) {
}
