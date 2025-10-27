package br.com.alexandrejnrx.controlprodapi.dto.converter;

import br.com.alexandrejnrx.controlprodapi.dto.product.ProductRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.product.ProductResponseDTO;
import br.com.alexandrejnrx.controlprodapi.model.Product;

public class ProductConverter {

    public static Product converterDTOParaEntidade(ProductRequestDTO productRequestDTO) {
        Product product = new Product();

        product.setUniqueProductNumber(productRequestDTO.getUniqueProductNumber());
        product.setSerialNumber(productRequestDTO.getSerialNumber());
        product.setProductionDate(productRequestDTO.getProductionDate());
        product.setBatchNumber(productRequestDTO.getBatchNumber());
        product.setProducerName(productRequestDTO.getProducerName());

        return product;
    }

    public static ProductResponseDTO converterEntidadeParaDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setUniqueProductNumber(product.getUniqueProductNumber());
        productResponseDTO.setSerialNumber(product.getSerialNumber());
        productResponseDTO.setProductionDate(product.getProductionDate());
        productResponseDTO.setBatchNumber(product.getBatchNumber());
        productResponseDTO.setProducerName(product.getProducerName());

        return productResponseDTO;
    }
}
