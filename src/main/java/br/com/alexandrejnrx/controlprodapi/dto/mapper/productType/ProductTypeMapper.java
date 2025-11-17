package br.com.alexandrejnrx.controlprodapi.dto.mapper.productType;

import br.com.alexandrejnrx.controlprodapi.dto.productType.ProductTypeCreateRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.productType.ProductTypeResponseDTO;
import br.com.alexandrejnrx.controlprodapi.model.ProductType;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeMapper {

    public ProductType toEntity(ProductTypeCreateRequestDTO dto) {
        ProductType productType = new ProductType();

        productType.setName(dto.getName());
        productType.setInternalCode(dto.getInternalCode());
        productType.setProject(dto.getProject());
        productType.setActive(dto.getActive());

        return productType;
    }

    public ProductTypeResponseDTO toResponseDTO(ProductType entity) {
        ProductTypeResponseDTO dto = new ProductTypeResponseDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setInternalCode(entity.getInternalCode());
        dto.setProject(entity.getProject());
        dto.setActive(entity.getActive());

        return dto;
    }
}
