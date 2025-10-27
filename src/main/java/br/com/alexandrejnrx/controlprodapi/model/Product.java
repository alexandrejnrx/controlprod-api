package br.com.alexandrejnrx.controlprodapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "unique_product_number", nullable = false, unique = true)
    private Integer uniqueProductNumber;
    @Column(name = "serial_number", unique = true)
    private Integer serialNumber;
    @Column(name = "production_date")
    private LocalDate productionDate;
    @Column(name = "batch_number", nullable = false)
    private Integer batchNumber;
    @Column(name = "producer_name", nullable = false, length = 100)
    private String producerName;

}
