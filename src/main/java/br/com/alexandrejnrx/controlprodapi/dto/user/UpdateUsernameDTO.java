package br.com.alexandrejnrx.controlprodapi.dto.user;

import jakarta.validation.constraints.NotBlank;

public record UpdateUsernameDTO(
        @NotBlank(message = "O campo nome de usuário não pode ser vazio.")
        String newUsername
) {
}
