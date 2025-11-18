package br.com.alexandrejnrx.controlprodapi.dto.product;

import jakarta.validation.Valid;

public record UpdateProducerNameDTO(
        @Valid
        String newProducerName
) {
}
