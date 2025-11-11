package br.com.alexandrejnrx.controlprodapi.dto.client;

import br.com.alexandrejnrx.controlprodapi.model.ClientType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponseDTO {

    private Integer id;
    private String name;
    private ClientType clientType;
    private Boolean active;

}
