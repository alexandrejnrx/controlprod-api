package br.com.alexandrejnrx.controlprodapi.dto.project;

import br.com.alexandrejnrx.controlprodapi.model.Client;
import br.com.alexandrejnrx.controlprodapi.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectCreateRequestDTO {

    @NotBlank(message = "O campo nome é obrigatório!")
    private String name;
    @NotNull(message = "O campo cliente é obrigatório!")
    private Client client;
    @NotNull(message = "O campo ativo é obrigatório!")
    private Boolean active;

}
