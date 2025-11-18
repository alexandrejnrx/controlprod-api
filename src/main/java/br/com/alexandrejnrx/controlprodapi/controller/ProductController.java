package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.product.ProductRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.product.ProductResponseDTO;
import br.com.alexandrejnrx.controlprodapi.dto.product.UpdateNup;
import br.com.alexandrejnrx.controlprodapi.dto.product.UpdateProductType;
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

    @PutMapping("/{id}/update-product-type")
    public ResponseEntity<Void> updateProductType(
            @PathVariable Integer id,
            @Valid
            @RequestBody UpdateProductType dto
    ) {
        productService.updateProductType(id, dto.newProductType());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/update-nup")
    public ResponseEntity<Void> updateNup(
            @PathVariable Integer id,
            @Valid
            @RequestBody UpdateNup dto
    ) {
        productService.updateNup(id, dto.newNup());

        return ResponseEntity.noContent().build();
    }
}
