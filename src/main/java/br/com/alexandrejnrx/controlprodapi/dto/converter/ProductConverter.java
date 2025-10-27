package br.com.alexandrejnrx.controlprodapi.dto.converter;

import br.com.alexandrejnrx.controlprodapi.dto.product.ProductRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.product.ProductResponseDTO;
import br.com.alexandrejnrx.controlprodapi.model.Product;

public class ProductConverter {

    public static Product converterDTOParaEntidade(ProductRequestDTO productRequestDTO) {
        Product product = new Product();

        product.setNumeroUnicoProducao(productRequestDTO.getNumeroUnicoProducao());
        product.setNumeroSerie(productRequestDTO.getNumeroSerie());
        product.setDataProducao(productRequestDTO.getDataProducao());
        product.setLote(productRequestDTO.getLote());
        product.setResponsavel(productRequestDTO.getResponsavel());

        return product;
    }

    public static ProductResponseDTO converterEntidadeParaDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setNumeroUnicoProducao(product.getNumeroUnicoProducao());
        productResponseDTO.setNumeroSerie(product.getNumeroSerie());
        productResponseDTO.setDataProducao(product.getDataProducao());
        productResponseDTO.setLote(product.getLote());
        productResponseDTO.setResponsavel(product.getResponsavel());

        return productResponseDTO;
    }
}
