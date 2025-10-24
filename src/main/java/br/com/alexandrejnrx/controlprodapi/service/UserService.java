package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.converter.UserConverter;
import br.com.alexandrejnrx.controlprodapi.dto.usuario.UserRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.usuario.UserResponseDTO;
import br.com.alexandrejnrx.controlprodapi.exception.UserNotFoundException;
import br.com.alexandrejnrx.controlprodapi.model.User;
import br.com.alexandrejnrx.controlprodapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final String ERRO_NOME_USUARIO_JA_CADASTRADO = "Nome de usuário já cadastrado";
    private static final String ERRO_EMAIL_JA_CADASTRADO = "E-mail já cadastrado";

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDTO> listarUsuarios() {
        return userRepository.findAll()
                .stream().
                map(UserConverter::converterEntidadeParaDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO buscarPorId(Integer id) {
        return userRepository.findById(id)
                .map(UserConverter::converterEntidadeParaDTO)
                .orElseThrow(() -> new UserNotFoundException());
    }

    public UserResponseDTO cadastrarUsuario(UserRequestDTO userRequestDTO) {
        String nomeUsuarioNormalizado = normalizarDados(userRequestDTO.getUsername());
        String emailNormalizado = normalizarDados(userRequestDTO.getEmail());

        if (userRepository.existsByUsername(nomeUsuarioNormalizado)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERRO_NOME_USUARIO_JA_CADASTRADO);
        }

        if (userRepository.existsByEmail(emailNormalizado)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERRO_EMAIL_JA_CADASTRADO);
        }

        User userParaCadastrar = UserConverter.converterDTOParaEntidade(userRequestDTO);

        userParaCadastrar.setUsername(nomeUsuarioNormalizado);
        userParaCadastrar.setEmail(emailNormalizado);
        userParaCadastrar.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));

        User userSalvo = userRepository.save(userParaCadastrar);
        return UserConverter.converterEntidadeParaDTO(userSalvo);
    }

    public void deletarUsuario(Integer id) {
        User userEncontrado = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        userRepository.delete(userEncontrado);
    }

    public UserResponseDTO alterarDados(Integer id, UserRequestDTO userRequestDTO) {
        User userEncontrado = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        if (userRequestDTO.getName() != null) {
            userEncontrado.setName(userRequestDTO.getName());
        }

        if (userRequestDTO.getUsername() != null) {
            String nomeUsuarioNormalizado = normalizarDados(userRequestDTO.getUsername());

            if (!userEncontrado.getUsername().equals(nomeUsuarioNormalizado)) {
                userEncontrado.setUsername(nomeUsuarioNormalizado);
            }
        }

        if (userRequestDTO.getPassword() != null) {
            userEncontrado.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        }

        User userAtualizado = userRepository.save(userEncontrado);
        return UserConverter.converterEntidadeParaDTO(userAtualizado);
    }

    private String normalizarDados(String dados) {
        return dados.toLowerCase().trim();
    }
}