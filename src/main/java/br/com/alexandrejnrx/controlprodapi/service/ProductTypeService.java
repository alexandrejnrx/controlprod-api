package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.exception.ProductTypeNotFoundException;
import br.com.alexandrejnrx.controlprodapi.model.ProductType;
import br.com.alexandrejnrx.controlprodapi.model.Project;
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

    public void delete(Integer id) {
        ProductType productTypeToDelete = findById(id);

        productTypeRepository.delete(productTypeToDelete);
    }

    public void updateName(Integer id, String newName) {
        ProductType productTypeToUpdate = findById(id);

        if (newName != null) {
            productTypeToUpdate.setName(newName);
        }

        productTypeRepository.save(productTypeToUpdate);
    }

    public void updateInternalCode(Integer id, String newInternalCode) {
        ProductType productTypeToUpdate = findById(id);

        if (newInternalCode != null) {
            productTypeToUpdate.setInternalCode(newInternalCode);
        }

        productTypeRepository.save(productTypeToUpdate);
    }

    public void updateProject(Integer id, Project newProject) {
        ProductType productTypeToUpdate = findById(id);

        if (newProject != null) {
            productTypeToUpdate.setProject(newProject);
        }

        productTypeRepository.save(productTypeToUpdate);
    }

    public void updateActive(Integer id, Boolean newActive) {
        ProductType productTypeToUpdate = findById(id);

        if (newActive != null) {
            productTypeToUpdate.setActive(newActive);
        }

        productTypeRepository.save(productTypeToUpdate);
    }

    private ProductType findById(Integer id) {
        return productTypeRepository.findById(id)
                .orElseThrow(ProductTypeNotFoundException::new);
    }
}
