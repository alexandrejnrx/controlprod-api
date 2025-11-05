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
    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;
    @Column(name = "unique_product_number", nullable = false, unique = true)
    private Integer uniqueProductNumber;
    @Column(name = "serial_number", unique = true)
    private Integer serialNumber;
    @Column(length = 20)
    private String modem;
    @Column(length = 100)
    private String imei;
    @Column(name = "firmware_version", length = 10)
    private String firmwareVersion;
    @Column(name = "production_date")
    private LocalDate productionDate;
    @Column(name = "batch_number", nullable = false)
    private Integer batchNumber;
    @Column(name = "producer_name", nullable = false, length = 100)
    private String producerName;

}
