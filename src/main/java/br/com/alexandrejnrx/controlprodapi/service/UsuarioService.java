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

    public void deletarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public void alterarDados(Integer id, Usuario usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id).get();

        if (usuario.getNome() != null) {
            usuarioEncontrado.setNome(usuario.getNome());
        }

        if (usuario.getNomeUsuario() != null) {
            usuarioEncontrado.setNomeUsuario(usuario.getNomeUsuario());
        }

        if (usuario.getSenha() != null) {
            usuarioEncontrado.setNome(usuario.getNome());
        }

        usuarioRepository.save(usuarioEncontrado);
    }
}
