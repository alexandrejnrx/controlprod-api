package br.com.alexandrejnrx.controlprodapi.dto.converter;

import br.com.alexandrejnrx.controlprodapi.dto.ProdutoRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.ProdutoResponseDTO;
import br.com.alexandrejnrx.controlprodapi.model.Produto;

public class ProdutoConverter {

    public static Produto converterDTOParaEntidade(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto();

        produto.setNumeroUnicoProducao(produtoRequestDTO.getNumeroUnicoProducao());
        produto.setNumeroSerie(produtoRequestDTO.getNumeroSerie());
        produto.setDataProducao(produtoRequestDTO.getDataProducao());
        produto.setLote(produtoRequestDTO.getLote());
        produto.setResponsavel(produtoRequestDTO.getResponsavel());

        return produto;
    }

    public static ProdutoResponseDTO converterEntidadeParaDTO(Produto produto) {
        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();

        produtoResponseDTO.setNumeroUnicoProducao(produto.getNumeroUnicoProducao());
        produtoResponseDTO.setNumeroSerie(produto.getNumeroSerie());
        produtoResponseDTO.setDataProducao(produto.getDataProducao());
        produtoResponseDTO.setLote(produto.getLote());
        produtoResponseDTO.setResponsavel(produto.getResponsavel());

        return produtoResponseDTO;
    }
}
