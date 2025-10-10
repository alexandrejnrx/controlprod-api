package br.com.alexandrejnrx.controlprodapi.controller;

import br.com.alexandrejnrx.controlprodapi.model.Usuario;
import br.com.alexandrejnrx.controlprodapi.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar-usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/cadastrar-usuario")
    public void cadastrarUsuario(@RequestBody Usuario usuario) {
        usuarioService.cadastrarUsuario(usuario);
    }

    @DeleteMapping("/deletar-usuario/{id}")
    public void deletarUsuario(@PathVariable("id") Integer id){
        usuarioService.deletarUsuario(id);
    }
}
