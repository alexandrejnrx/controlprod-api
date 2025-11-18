package br.com.alexandrejnrx.controlprodapi.dto.client;

import br.com.alexandrejnrx.controlprodapi.model.ClientType;
import jakarta.validation.constraints.NotNull;

public record UpdateClientTypeDTO(
        @NotNull(message = "O campo tipo cliente não pode ser vazio!")
        ClientType newClientType
) {
}
