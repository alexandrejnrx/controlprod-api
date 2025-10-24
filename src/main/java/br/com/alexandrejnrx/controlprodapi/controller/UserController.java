package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.usuario.UserRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.usuario.UserResponseDTO;
import br.com.alexandrejnrx.controlprodapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listarUsuarios() {
        return ResponseEntity.ok(userService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> buscar(@PathVariable Integer id) {
        UserResponseDTO userResponseDTO = userService.buscarPorId(id);

        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> cadastrar(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO usuarioCriado = userService.cadastrarUsuario(userRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
        userService.deletarUsuario(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> atualizar(@PathVariable("id") Integer id, @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO usuarioAtualizado = userService.alterarDados(id, userRequestDTO);
        userService.alterarDados(id, userRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioAtualizado);
    }
}
