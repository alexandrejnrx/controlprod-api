package br.com.alexandrejnrx.controlprodapi.dto.mapper.product;

import br.com.alexandrejnrx.controlprodapi.dto.product.ProductRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.product.ProductResponseDTO;
import br.com.alexandrejnrx.controlprodapi.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();

        product.setProductType(dto.getProductType());
        product.setNup(dto.getNup());
        product.setSerialNumber(dto.getSerialNumber());
        product.setModem(dto.getModem());
        product.setImei(dto.getImei());
        product.setFirmwareVersion(dto.getFirmwareVersion());
        product.setProductionDate(dto.getProductionDate());
        product.setBatchNumber(dto.getBatchNumber());
        product.setProducerName(dto.getProducerName());

        return product;
    }

    public ProductResponseDTO toResponseDTO(Product entity) {
        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(entity.getId());
        dto.setProductType(entity.getProductType());
        dto.setNup(entity.getNup());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setModem(entity.getModem());
        dto.setImei(entity.getImei());
        dto.setFirmwareVersion(entity.getFirmwareVersion());
        dto.setProductionDate(entity.getProductionDate());
        dto.setBatchNumber(entity.getBatchNumber());
        dto.setProducerName(entity.getProducerName());

        return dto;
    }
}
