package br.com.alexandrejnrx.controlprodapi.dto.productType;

import br.com.alexandrejnrx.controlprodapi.model.Project;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductTypeCreateRequestDTO {

    @NotBlank(message = "O campo nome, não pode ser vazio!")
    private String name;
    @NotBlank(message = "O campo código, não pode ser vazio!")
    private String internalCode;
    @NotNull(message = "O campo projeto, não pode ser vazio!")
    private Project project;
    @NotNull(message = "O campo ativo, não pode ser vazio!")
    private Boolean active;
}
