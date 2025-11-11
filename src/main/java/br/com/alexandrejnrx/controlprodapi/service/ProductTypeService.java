package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.model.ProductType;
import br.com.alexandrejnrx.controlprodapi.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }


    public void create(ProductType productType) {
        productTypeRepository.save(productType);
    }
}
