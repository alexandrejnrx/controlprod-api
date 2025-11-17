package br.com.alexandrejnrx.controlprodapi.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateEmailDTO(
        @NotBlank
        @Email
        String newEmail
) {
}
