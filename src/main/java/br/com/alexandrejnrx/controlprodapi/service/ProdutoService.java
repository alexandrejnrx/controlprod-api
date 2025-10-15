package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.model.Produto;
import br.com.alexandrejnrx.controlprodapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
}
