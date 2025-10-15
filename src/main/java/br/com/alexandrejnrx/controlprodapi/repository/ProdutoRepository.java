package br.com.alexandrejnrx.controlprodapi.repository;

import br.com.alexandrejnrx.controlprodapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
