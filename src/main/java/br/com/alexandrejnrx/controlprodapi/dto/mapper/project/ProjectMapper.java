package br.com.alexandrejnrx.controlprodapi.dto.mapper.project;

import br.com.alexandrejnrx.controlprodapi.dto.project.ProjectCreateRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.project.ProjectResponseDTO;
import br.com.alexandrejnrx.controlprodapi.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public Project toEntity(ProjectCreateRequestDTO dto) {
        Project project = new Project();

        project.setName(dto.getName());
        project.setClient(dto.getClient());
        project.setActive(dto.getActive());

        return project;
    }

    public ProjectResponseDTO toResponseDTO(Project entity) {
        ProjectResponseDTO dto = new ProjectResponseDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setClient(entity.getClient());
        dto.setActive(entity.getActive());

        return dto;
    }
}
