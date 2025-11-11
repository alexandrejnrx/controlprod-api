package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.user.ChangeUsernameDTO;
import br.com.alexandrejnrx.controlprodapi.dto.user.UpdateNameDTO;
import br.com.alexandrejnrx.controlprodapi.dto.user.CreateDTO;
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
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody CreateDTO createDTO) {
        userService.create(createDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<UserResponseDTO> updateName(@PathVariable Integer id, @Valid @RequestBody UpdateNameDTO dto) {
        userService.updateName(id, dto.newName());
        UserResponseDTO updatedUser = userService.findById(id);

        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{id}/username")
    public ResponseEntity<UserResponseDTO> changeUsername(@PathVariable Integer id, @Valid @RequestBody ChangeUsernameDTO dto) {
        userService.changeUsername(id, dto);
        UserResponseDTO updatedUser = userService.findById(id);

        return ResponseEntity.ok(updatedUser);
    }
}
