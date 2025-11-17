package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.user.*;
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

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody UserCreateRequestDTO newUser) {
        userService.create(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<Void> updateName(@PathVariable Integer id, @RequestBody UpdateNameDTO dto) {
        userService.updateName(id, dto.newName());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/username")
    public ResponseEntity<UserResponseDTO> changeUsername(@PathVariable Integer id, @Valid @RequestBody ChangeUsernameDTO dto) {
        userService.changeUsername(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/email")
    public ResponseEntity<Void> updateEmail(@PathVariable Integer id, @Valid @RequestBody UpdateEmailDTO dto) {
        userService.updateEmail(id, dto.newEmail());

        return ResponseEntity.noContent().build();
    }
}
