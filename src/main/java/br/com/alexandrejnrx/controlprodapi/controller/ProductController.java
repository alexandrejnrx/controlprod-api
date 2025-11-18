package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.product.*;
import br.com.alexandrejnrx.controlprodapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(
            @RequestBody
            ProductRequestDTO productRequestDTO
    ) {
        productService.create(productRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable
            Integer id
    ) {
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/update-product-type")
    public ResponseEntity<Void> updateProductType(
            @PathVariable Integer id,
            @Valid
            @RequestBody UpdateProductTypeDTO dto
    ) {
        productService.updateProductType(id, dto.newProductType());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/update-nup")
    public ResponseEntity<Void> updateNup(
            @PathVariable Integer id,
            @Valid
            @RequestBody UpdateNup dto
    ) {
        productService.updateNup(id, dto.newNup());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/update-serial-number")
    public ResponseEntity<Void> updateSerialNumber(
            @PathVariable Integer id,
            @RequestBody UpdateSerialNumberDTO dto
    ) {
        productService.updateSerialNumber(id, dto.newSerialNumber());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/update-modem")
    public ResponseEntity<Void> updateModem(
            @PathVariable Integer id,
            @RequestBody UpdateModemDTO dto
    ) {
        productService.updateModem(id, dto.newModem());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/update-imei")
    public ResponseEntity<Void> updateImei(
            @PathVariable Integer id,
            @RequestBody UpdateImeiDTO dto
    ) {
        productService.updateImei(id, dto.newImei());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/update-firmware-version")
    public ResponseEntity<Void> updateFirmwareVersion(
            @PathVariable Integer id,
            @RequestBody UpdateFirmwareVersionDTO dto
    ) {
        productService.updateFirmwareVersion(id, dto.newFirmwareVersion());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/update-production-date")
    public ResponseEntity<Void> updateProductionDate(
            @PathVariable Integer id,
            @RequestBody UpdateProductionDateDTO dto
    ) {
        productService.updateProductionDate(id, dto.newProductionDate());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/update-batch-number")
    public ResponseEntity<Void> updateBatchNumber(
            @PathVariable Integer id,
            @Valid
            @RequestBody UpdateBatchNumberDTO dto
    ) {
        productService.updateBatchNumber(id, dto.batchNumber());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/update-producer-name")
    public ResponseEntity<Void> updateProducerName(
            @PathVariable Integer id,
            @Valid
            @RequestBody UpdateProducerNameDTO dto
    ) {
        productService.updateProducerName(id, dto.newProducerName());

        return ResponseEntity.noContent().build();
    }
}
