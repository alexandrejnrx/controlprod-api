package br.com.alexandrejnrx.controlprodapi.dto.product;

import br.com.alexandrejnrx.controlprodapi.model.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductRequestDTO {

    private ProductType productType;
    private Integer nup;
    private Integer serialNumber;
    private String modem;
    private String imei;
    private String firmwareVersion;
    private LocalDate productionDate;
    private Integer batchNumber;
    private String producerName;
}
