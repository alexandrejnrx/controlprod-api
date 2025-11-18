package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.mapper.product.ProductMapper;
import br.com.alexandrejnrx.controlprodapi.dto.product.ProductRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.product.ProductResponseDTO;
import br.com.alexandrejnrx.controlprodapi.exception.ProductNotFoundException;
import br.com.alexandrejnrx.controlprodapi.exception.ProductNupAlreadyRegisteredException;
import br.com.alexandrejnrx.controlprodapi.model.Product;
import br.com.alexandrejnrx.controlprodapi.model.ProductType;
import br.com.alexandrejnrx.controlprodapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void create(ProductRequestDTO productRequestDTO) {
        if (productRepository.existsByNup(productRequestDTO.getNup())) {
            throw new ProductNupAlreadyRegisteredException();
        }

        Product productToCreate = productMapper.toEntity(productRequestDTO);
        productRepository.save(productToCreate);
    }

    public void delete(Integer id) {
        Product product = findById(id);

        productRepository.deleteById(id);
    }

    public void updateProductType(Integer id, ProductType newProductType) {
        Product existingProduct = findById(id);

        existingProduct.setProductType(newProductType);
        productRepository.save(existingProduct);
    }

    public void updateNup(Integer id, Integer newNup) {
        Product existingProduct = findById(id);

        existingProduct.setNup(newNup);
        productRepository.save(existingProduct);
    }

    public void updateSerialNumber(Integer id, Integer newSerialNumber) {
        Product existingProduct = findById(id);

        existingProduct.setSerialNumber(newSerialNumber);
        productRepository.save(existingProduct);
    }

    public void updateModem(Integer id, String newModem) {
        Product existingProduct = findById(id);

        existingProduct.setModem(newModem);
        productRepository.save(existingProduct);
    }

    public void updateImei(Integer id, String newImei) {
        Product existingProduct = findById(id);

        existingProduct.setImei(newImei);
        productRepository.save(existingProduct);
    }

    public void updateFirmwareVersion(Integer id, String newFirmwareVersion) {
        Product existingProduct = findById(id);

        existingProduct.setFirmwareVersion(newFirmwareVersion);
        productRepository.save(existingProduct);
    }

    public void updateProductionDate(Integer id, LocalDate newProductionDate) {
        Product existingProduct = findById(id);

        existingProduct.setProductionDate(newProductionDate);
        productRepository.save(existingProduct);
    }

    public void updateBatchNumber(Integer id, Integer newBatchNumber) {
        Product existingProduct = findById(id);

        existingProduct.setBatchNumber(newBatchNumber);
        productRepository.save(existingProduct);
    }

    private Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }
}
