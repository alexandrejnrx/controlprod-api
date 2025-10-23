package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.produto.ProdutoRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.produto.ProdutoResponseDTO;
import br.com.alexandrejnrx.controlprodapi.service.ProdutoService;
import br.com.alexandrejnrx.controlprodapi.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final UsuarioService usuarioService;

    public ProdutoController(ProdutoService produtoService, UsuarioService usuarioService) {
        this.produtoService = produtoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrar(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        ProdutoResponseDTO produtoCriado = produtoService.cadastrarProduto(produtoRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }
}
