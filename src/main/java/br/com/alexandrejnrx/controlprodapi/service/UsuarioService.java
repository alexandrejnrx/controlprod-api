package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.converter.UsuarioConverter;
import br.com.alexandrejnrx.controlprodapi.dto.usuario.UsuarioRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.usuario.UsuarioResponseDTO;
import br.com.alexandrejnrx.controlprodapi.exception.UserNotFoundException;
import br.com.alexandrejnrx.controlprodapi.model.Usuario;
import br.com.alexandrejnrx.controlprodapi.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private static final String ERRO_NOME_USUARIO_JA_CADASTRADO = "Nome de usuário já cadastrado";
    private static final String ERRO_EMAIL_JA_CADASTRADO = "E-mail já cadastrado";

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream().
                map(UsuarioConverter::converterEntidadeParaDTO)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO buscarPorId(Integer id) {
        return usuarioRepository.findById(id)
                .map(UsuarioConverter::converterEntidadeParaDTO)
                .orElseThrow(() -> new UserNotFoundException());
    }

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        String nomeUsuarioNormalizado = normalizarDados(usuarioRequestDTO.getNomeUsuario());
        String emailNormalizado = normalizarDados(usuarioRequestDTO.getEmail());

        if (usuarioRepository.existsByNomeUsuario(nomeUsuarioNormalizado)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERRO_NOME_USUARIO_JA_CADASTRADO);
        }

        if (usuarioRepository.existsByEmail(emailNormalizado)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERRO_EMAIL_JA_CADASTRADO);
        }

        Usuario usuarioParaCadastrar = UsuarioConverter.converterDTOParaEntidade(usuarioRequestDTO);

        usuarioParaCadastrar.setNomeUsuario(nomeUsuarioNormalizado);
        usuarioParaCadastrar.setEmail(emailNormalizado);
        usuarioParaCadastrar.setSenha(passwordEncoder.encode(usuarioRequestDTO.getSenha()));

        Usuario usuarioSalvo = usuarioRepository.save(usuarioParaCadastrar);
        return UsuarioConverter.converterEntidadeParaDTO(usuarioSalvo);
    }

    public void deletarUsuario(Integer id) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        usuarioRepository.delete(usuarioEncontrado);
    }

    public UsuarioResponseDTO alterarDados(Integer id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        if (usuarioRequestDTO.getNome() != null) {
            usuarioEncontrado.setNome(usuarioRequestDTO.getNome());
        }

        if (usuarioRequestDTO.getNomeUsuario() != null) {
            String nomeUsuarioNormalizado = normalizarDados(usuarioRequestDTO.getNomeUsuario());

            if (!usuarioEncontrado.getNomeUsuario().equals(nomeUsuarioNormalizado)) {
                usuarioEncontrado.setNomeUsuario(nomeUsuarioNormalizado);
            }
        }

        if (usuarioRequestDTO.getSenha() != null) {
            usuarioEncontrado.setSenha(passwordEncoder.encode(usuarioRequestDTO.getSenha()));
        }

        Usuario usuarioAtualizado = usuarioRepository.save(usuarioEncontrado);
        return UsuarioConverter.converterEntidadeParaDTO(usuarioAtualizado);
    }

    private String normalizarDados(String dados) {
        return dados.toLowerCase().trim();
    }
}