package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.converter.ProductConverter;
import br.com.alexandrejnrx.controlprodapi.dto.product.ProductRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.product.ProductResponseDTO;
import br.com.alexandrejnrx.controlprodapi.exception.ProductNotFoundException;
import br.com.alexandrejnrx.controlprodapi.model.Product;
import br.com.alexandrejnrx.controlprodapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductConverter::converterEntidadeParaDTO)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO findById(Integer id) {
        return productRepository.findById(id)
                .map(ProductConverter::converterEntidadeParaDTO)
                .orElseThrow(() -> new ProductNotFoundException());
    }

    public ProductResponseDTO create(ProductRequestDTO productRequestDTO) {
        Product productToCreate = ProductConverter.converterDTOParaEntidade(productRequestDTO);
        Product productToSave = productRepository.save(productToCreate);

        return ProductConverter.converterEntidadeParaDTO(productToSave);
    }

    public void delete(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException());

        productRepository.deleteById(id);
    }
}
