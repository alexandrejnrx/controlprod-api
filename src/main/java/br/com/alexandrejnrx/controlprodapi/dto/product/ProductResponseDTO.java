package br.com.alexandrejnrx.controlprodapi.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductResponseDTO {

    private Integer uniqueProductNumber;
    private Integer serialNumber;
    private LocalDate productionDate;
    private Integer batchNumber;
    private String producerName;

}
