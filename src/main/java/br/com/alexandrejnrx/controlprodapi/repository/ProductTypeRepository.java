package br.com.alexandrejnrx.controlprodapi.repository;

import br.com.alexandrejnrx.controlprodapi.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
