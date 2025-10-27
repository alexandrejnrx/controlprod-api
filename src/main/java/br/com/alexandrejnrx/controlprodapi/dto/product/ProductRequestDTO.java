package br.com.alexandrejnrx.controlprodapi.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductRequestDTO {

    private Integer numeroUnicoProducao;
    private Integer numeroSerie;
    private LocalDate dataProducao;
    private Integer lote;
    private String responsavel;

}
