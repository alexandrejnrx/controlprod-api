package br.com.alexandrejnrx.controlprodapi.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeUsernameDTO {

    @NotBlank(message = "O campo nome de usuário não pode ser vazio.")
    private String username;
    @NotBlank(message = "O campo senha não pode ser vazio.")
    private String password;

}
