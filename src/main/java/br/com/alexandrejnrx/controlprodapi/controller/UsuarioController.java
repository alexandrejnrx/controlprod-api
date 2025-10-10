package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.dto.UsuarioRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.UsuarioResponseDTO;
import br.com.alexandrejnrx.controlprodapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar-usuarios")
    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/cadastrar-usuario")
    public void cadastrarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioService.cadastrarUsuario(usuarioRequestDTO);
    }

    @DeleteMapping("/deletar-usuario/{id}")
    public void deletarUsuario(@PathVariable("id") Integer id) {
        usuarioService.deletarUsuario(id);
    }

    @PutMapping("/alterar-dados/{id}")
    public void alterarDados(@PathVariable("id") Integer id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioService.alterarDados(id, usuarioRequestDTO);
    }
}
