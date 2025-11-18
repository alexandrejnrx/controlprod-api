package br.com.alexandrejnrx.controlprodapi.dto.product;

import java.time.LocalDate;

public record UpdateProductionDateDTO(
        LocalDate newProductionDate
) {
}
