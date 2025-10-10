package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.UsuarioRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.UsuarioResponseDTO;
import br.com.alexandrejnrx.controlprodapi.dto.converter.UsuarioConverter;
import br.com.alexandrejnrx.controlprodapi.model.Usuario;
import br.com.alexandrejnrx.controlprodapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream().
                map(UsuarioConverter::converterEntidadeParaDTO)
                .collect(Collectors.toList());
    }

    public void cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuarioParaCadastrar = UsuarioConverter.converterDTOParaEntidade(usuarioRequestDTO);

        usuarioRepository.save(usuarioParaCadastrar);
    }

    public void deletarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public void alterarDados(Integer id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id).get();

        Usuario usuarioParaAlterar = UsuarioConverter.converterDTOParaEntidade(usuarioRequestDTO);

        if (usuarioParaAlterar.getNome() != null) {
            usuarioEncontrado.setNome(usuarioRequestDTO.getNome());
        }

        if (usuarioParaAlterar.getNomeUsuario() != null) {
            usuarioEncontrado.setNomeUsuario(usuarioRequestDTO.getNomeUsuario());
        }

        if (usuarioParaAlterar.getSenha() != null) {
            usuarioEncontrado.setNome(usuarioRequestDTO.getSenha());
        }

        usuarioRepository.save(usuarioEncontrado);
    }
}
