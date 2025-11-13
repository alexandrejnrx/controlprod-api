package br.com.alexandrejnrx.controlprodapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "technical_assistance")
@Getter
@Setter
public class TechnicalAssistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false, length = 50)
    private String requester;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private DefectOrigin origin;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Column(name = "defect_reason", nullable = false, length = 150)
    private String defectReason;
    @Column(nullable = false, length = 50)
    private String responsible;
    @Column(length = 1000)
    private String resolution;
}