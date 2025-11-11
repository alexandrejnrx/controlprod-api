package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.client.ClientCreateRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.client.ClientResponseDTO;
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
    public ResponseEntity<ClientResponseDTO> create(@Valid @RequestBody ClientCreateRequestDTO clientCreateRequestDTO) {
        clientService.create(clientCreateRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}