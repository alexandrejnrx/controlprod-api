package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.product.ProductRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.product.ProductResponseDTO;
import br.com.alexandrejnrx.controlprodapi.service.ProductService;
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
    public ResponseEntity<List<ProductResponseDTO>> listarProdutos() {
        return ResponseEntity.ok(productService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> buscar(@PathVariable Integer id) {
        return productService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> cadastrar(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO produtoCriado = productService.cadastrarProduto(productRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }
}
