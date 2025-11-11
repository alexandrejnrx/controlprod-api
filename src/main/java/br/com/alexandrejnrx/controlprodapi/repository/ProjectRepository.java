package br.com.alexandrejnrx.controlprodapi.repository;

import br.com.alexandrejnrx.controlprodapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
