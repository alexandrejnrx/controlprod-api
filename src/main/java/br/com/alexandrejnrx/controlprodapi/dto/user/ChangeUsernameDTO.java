package br.com.alexandrejnrx.controlprodapi.dto.user;

import jakarta.validation.constraints.NotBlank;

public record ChangeUsernameDTO(
        @NotBlank(message = "O campo nome de usuário não pode ser vazio.")
        String newUsername,
        @NotBlank(message = "O campo senha não pode ser vazio.")
        String password
) {
}