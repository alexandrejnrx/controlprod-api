package br.com.alexandrejnrx.controlprodapi.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record AuthDTO(
        @NotBlank(message = "O nome de usuário é obrigatório!")
        String username,

        @NotBlank(message = "A senha é obrigatória!")
        String password
) {
}