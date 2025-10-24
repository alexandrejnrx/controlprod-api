package br.com.alexandrejnrx.controlprodapi.dto.usuario;

import br.com.alexandrejnrx.controlprodapi.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "O campo nome não pode ser vazio.")
    private String name;
    @NotBlank(message = "O campo nome de usuário não pode ser vazio.")
    private String username;
    @NotBlank(message = "O campo e-mail não pode ser vazio.")
    private String email;
    @NotBlank(message = "O campo senha não pode ser vazio.")
    private String password;
    @NotNull(message = "O perfil é obrigatório")
    private Role role;

}
