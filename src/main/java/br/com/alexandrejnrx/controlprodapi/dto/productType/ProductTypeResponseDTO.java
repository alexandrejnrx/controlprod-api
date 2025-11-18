package br.com.alexandrejnrx.controlprodapi.dto.productType;

import br.com.alexandrejnrx.controlprodapi.model.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductTypeResponseDTO {

    private Integer id;
    private String name;
    private String internalCode;
    private Project project;
    private Boolean active;
}
