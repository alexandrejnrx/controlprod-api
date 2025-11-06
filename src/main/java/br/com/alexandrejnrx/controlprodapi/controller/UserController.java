package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.user.ChangeUsernameDTO;
import br.com.alexandrejnrx.controlprodapi.dto.user.UpdateNameDTO;
import br.com.alexandrejnrx.controlprodapi.dto.user.UserCreateRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.user.UserResponseDTO;
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
    public ResponseEntity<List<UserResponseDTO>> getUsers() {

        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Integer id) {
        UserResponseDTO userResponseDTO = userService.findById(id);

        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserCreateRequestDTO userCreateRequestDTO) {
        UserResponseDTO createdUser = userService.create(userCreateRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<UserResponseDTO> updateName(@PathVariable("id") Integer id, @RequestBody UpdateNameDTO dto) {
        UserResponseDTO updatedUser = userService.updateName(id, dto);

        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{id}/username")
    public ResponseEntity<UserResponseDTO> changeUsername(@PathVariable("id") Integer id, @Valid @RequestBody ChangeUsernameDTO dto) {
        UserResponseDTO updatedUser = userService.changeUsername(id, dto);

        return ResponseEntity.ok(updatedUser);
    }
}
