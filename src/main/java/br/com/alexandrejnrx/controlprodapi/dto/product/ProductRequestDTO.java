package br.com.alexandrejnrx.controlprodapi.dto.product;

import br.com.alexandrejnrx.controlprodapi.model.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductRequestDTO {

    @NotNull(message = "O campo tipo produto não pode ser vazio.")
    private ProductType productType;
    @NotBlank(message = "O campo nup não pode ser vazio.")
    private Integer nup;
    private Integer serialNumber;
    private String modem;
    private String imei;
    private String firmwareVersion;
    @NotBlank(message = "O campo data de produção não pode ser vazio.")
    private LocalDate productionDate;
    @NotBlank(message = "O campo lote não pode ser vazio.")
    private Integer batchNumber;
    @NotBlank(message = "O campo resposável não pode ser vazio.")
    private String producerName;
}
