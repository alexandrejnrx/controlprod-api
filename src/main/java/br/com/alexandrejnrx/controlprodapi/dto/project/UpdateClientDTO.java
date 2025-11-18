package br.com.alexandrejnrx.controlprodapi.dto.project;

import br.com.alexandrejnrx.controlprodapi.model.Client;
import jakarta.validation.constraints.NotNull;

public record UpdateClientDTO(
        @NotNull(message = "O campo cliente não pode ser vazio.")
        Client newClient
) {
}
