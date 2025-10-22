package br.com.alexandrejnrx.controlprodapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProdutoResponseDTO {

    private Integer numeroUnicoProducao;
    private Integer numeroSerie;
    private LocalDate dataProducao;
    private Integer lote;
    private String responsavel;

}
