package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.model.Usuario;
import br.com.alexandrejnrx.controlprodapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
