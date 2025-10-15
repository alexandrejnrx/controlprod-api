package br.com.alexandrejnrx.controlprodapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "produtos")
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_unico_producao", nullable = false, unique = true)
    private Integer numeroUnicoProducao;
    @Column(name = "numeroSerie", unique = true)
    private Integer numeroSerie; //numero_serie
    @Column(name = "data_producao")
    private LocalDate dataProducao;
    @Column(nullable = false)
    private Integer lote;
    @Column(nullable = false, length = 100)
    private String responsavel;

}
