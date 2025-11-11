package br.com.alexandrejnrx.controlprodapi.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeUsernameDTO {


    @NotBlank(message = "O campo nome de usuário não pode ser vazio.")
    private String newUsername;
    @NotBlank(message = "O campo senha não pode ser vazio.")
    private String password;


    public void setUsername(String newUsername) {
        this.newUsername = newUsername.toLowerCase().trim();
    }
}
