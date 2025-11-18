package br.com.alexandrejnrx.controlprodapi.dto.productType;

import br.com.alexandrejnrx.controlprodapi.model.Project;
import jakarta.validation.constraints.NotNull;

public record UpdateProjectDTO(
        @NotNull(message = "O campo projeto, não pode ser vazio.")
        Project newProject
) {
}
