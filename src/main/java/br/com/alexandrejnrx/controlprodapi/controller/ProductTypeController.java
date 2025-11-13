package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.model.ProductType;
import br.com.alexandrejnrx.controlprodapi.service.ProductTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-types")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public ResponseEntity<List<ProductType>> findAll() {

        return ResponseEntity.ok(productTypeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProductType productType) {
        productTypeService.create(productType);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productTypeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
