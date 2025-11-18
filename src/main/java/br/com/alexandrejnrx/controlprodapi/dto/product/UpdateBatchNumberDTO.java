package br.com.alexandrejnrx.controlprodapi.dto.product;

import jakarta.validation.constraints.NotBlank;

public record UpdateBatchNumberDTO(
        @NotBlank(message = "O campo lote não pode ser vazio.")
        Integer batchNumber
) {
}
