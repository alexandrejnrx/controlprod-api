package br.com.alexandrejnrx.controlprodapi.dto.project;

import br.com.alexandrejnrx.controlprodapi.model.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponseDTO {

    private Integer id;
    private String name;
    private Client client;
    private Boolean active;

}
