package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.model.Project;
import br.com.alexandrejnrx.controlprodapi.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAll() {

        return ResponseEntity.ok(projectService.findAll());
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project) {
        projectService.create(project);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
