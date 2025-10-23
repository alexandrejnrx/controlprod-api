package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.converter.ProdutoConverter;
import br.com.alexandrejnrx.controlprodapi.dto.produto.ProdutoRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.produto.ProdutoResponseDTO;
import br.com.alexandrejnrx.controlprodapi.model.Produto;
import br.com.alexandrejnrx.controlprodapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoResponseDTO> listarProdutos() {
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoConverter::converterEntidadeParaDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProdutoResponseDTO> buscarPorId(Integer id) {
        return produtoRepository.findById(id)
                .map(ProdutoConverter::converterEntidadeParaDTO);
    }

    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produtoParaCadastrar = ProdutoConverter.converterDTOParaEntidade(produtoRequestDTO);
        Produto produtoSalvo = produtoRepository.save(produtoParaCadastrar);

        return ProdutoConverter.converterEntidadeParaDTO(produtoSalvo);
    }
}
