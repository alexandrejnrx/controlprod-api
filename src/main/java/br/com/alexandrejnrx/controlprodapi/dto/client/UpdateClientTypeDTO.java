package br.com.alexandrejnrx.controlprodapi.dto.client;

import br.com.alexandrejnrx.controlprodapi.model.ClientType;
import jakarta.validation.constraints.NotNull;

public record UpdateClientTypeDTO(
        @NotNull
        ClientType newClientType) {
}
