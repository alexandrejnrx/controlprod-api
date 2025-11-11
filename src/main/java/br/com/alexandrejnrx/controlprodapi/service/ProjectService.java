package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.model.Project;
import br.com.alexandrejnrx.controlprodapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void create(Project project) {
        projectRepository.save(project);
    }
}
