package br.com.alexandrejnrx.controlprodapi.dto.client;

import br.com.alexandrejnrx.controlprodapi.model.ClientType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientCreateRequestDTO {
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String name;
    @NotNull(message = "O tipo do cliente não pode ser vazio!")
    private ClientType clientType;
    @NotNull(message = "O campo ativo não pode ser vazio!")
    private Boolean active;
}
