package br.com.alexandrejnrx.controlprodapi.dto.mapper;

import br.com.alexandrejnrx.controlprodapi.dto.product.ProductRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.product.ProductResponseDTO;
import br.com.alexandrejnrx.controlprodapi.model.Product;

public class ProductConverter {

    public static Product converterDTOParaEntidade(ProductRequestDTO productRequestDTO) {
        Product product = new Product();

        product.setProductType(productRequestDTO.getProductType());
        product.setUniqueProductNumber(productRequestDTO.getUniqueProductNumber());
        product.setSerialNumber(productRequestDTO.getSerialNumber());
        product.setModem(productRequestDTO.getModem());
        product.setImei(productRequestDTO.getImei());
        product.setFirmwareVersion(productRequestDTO.getFirmwareVersion());
        product.setProductionDate(productRequestDTO.getProductionDate());
        product.setBatchNumber(productRequestDTO.getBatchNumber());
        product.setProducerName(productRequestDTO.getProducerName());

        return product;
    }

    public static ProductResponseDTO converterEntidadeParaDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setId(product.getId());
        productResponseDTO.setProductType(product.getProductType());
        productResponseDTO.setUniqueProductNumber(product.getUniqueProductNumber());
        productResponseDTO.setSerialNumber(product.getSerialNumber());
        productResponseDTO.setModem(product.getModem());
        productResponseDTO.setImei(product.getImei());
        productResponseDTO.setFirmwareVersion(product.getFirmwareVersion());
        productResponseDTO.setProductionDate(product.getProductionDate());
        productResponseDTO.setBatchNumber(product.getBatchNumber());
        productResponseDTO.setProducerName(product.getProducerName());

        return productResponseDTO;
    }
}
