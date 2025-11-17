package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.client.*;
import br.com.alexandrejnrx.controlprodapi.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll() {

        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(
            @Valid
            @RequestBody ClientCreateRequestDTO dto
    ) {
        clientService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id
    ) {
        clientService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<Void> updateName(
            @PathVariable Integer id,
            @Valid
            @RequestBody UpdateNameDTO dto
    ) {
        clientService.updateName(id, dto.newName());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/client-type")
    public ResponseEntity<Void> updateClientType(
            @PathVariable Integer id,
            @Valid
            @RequestBody UpdateClientTypeDTO dto
    ) {
        clientService.updateClientType(id, dto.newClientType());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Void> updateActive(
            @PathVariable Integer id,
            @Valid
            @RequestBody UpdateActiveDTO dto
    ) {
        clientService.updateActive(id, dto.newActive());

        return ResponseEntity.noContent().build();
    }
}