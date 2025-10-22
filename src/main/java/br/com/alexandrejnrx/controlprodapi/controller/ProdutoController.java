package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.produto.ProdutoRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.produto.ProdutoResponseDTO;
import br.com.alexandrejnrx.controlprodapi.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar-produtos")
    public List<ProdutoResponseDTO> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @PostMapping("/cadastrar-produto")
    public void cadastrarProduto(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        produtoService.cadastrarProduto(produtoRequestDTO);
    }
}
