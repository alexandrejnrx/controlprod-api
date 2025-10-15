package br.com.alexandrejnrx.controlprodapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequestDTO {

    @NotBlank(message = "O campo nome não pode ser vazio.")
    private String nome;
    @NotBlank(message = "O campo nome de usuário não pode ser vazio.")
    private String nomeUsuario;
    @NotBlank(message = "O campo e-mail não pode ser vazio.")
    private String email;
    @NotBlank(message = "O campo senha não pode ser vazio.")
    private String senha;

}
