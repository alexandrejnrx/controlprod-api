package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.mapper.project.ProjectMapper;
import br.com.alexandrejnrx.controlprodapi.dto.project.ProjectCreateRequestDTO;
import br.com.alexandrejnrx.controlprodapi.exception.ProjectNameAlreadyRegisteredException;
import br.com.alexandrejnrx.controlprodapi.exception.ProjectNotFoundException;
import br.com.alexandrejnrx.controlprodapi.model.Project;
import br.com.alexandrejnrx.controlprodapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void create(ProjectCreateRequestDTO newProject) {
        if (projectRepository.existsByName(newProject.getName())) {
            throw new ProjectNameAlreadyRegisteredException();
        }

        Project project = projectMapper.toEntity(newProject);
        projectRepository.save(project);
    }

    public void delete(Integer id) {
        Project projectToDelete = findById(id);

        projectRepository.delete(projectToDelete);
    }

    public void updateName(Integer id, String newName) {
        Project projectToUpdate = findById(id);

        projectToUpdate.setName(newName);
    }

    private Project findById(Integer id) {
        return projectRepository.findById(id)
                .orElseThrow(ProjectNotFoundException::new);
    }
}
