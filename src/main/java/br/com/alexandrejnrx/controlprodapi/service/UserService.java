package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.converter.UserMapper;
import br.com.alexandrejnrx.controlprodapi.dto.user.ChangeUsernameDTO;
import br.com.alexandrejnrx.controlprodapi.dto.user.UpdateNameDTO;
import br.com.alexandrejnrx.controlprodapi.dto.user.UserCreateRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.user.UserResponseDTO;
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
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private static final String ERROR_USERNAME_ALREADY_EXISTS = "Nome de usuário já cadastrado";
    private static final String ERROR_EMAIL_ALREADY_EXISTS = "E-mail já cadastrado";

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream().
                map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO findById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toResponseDTO)
                .orElseThrow(UserNotFoundException::new);
    }

    public UserResponseDTO create(UserCreateRequestDTO dto) {
        String normalizedUsername = normalizeData(dto.getUsername());
        String normalizedEmail = normalizeData(dto.getEmail());

        if (userRepository.existsByUsername(normalizedUsername)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERROR_USERNAME_ALREADY_EXISTS);
        }

        if (userRepository.existsByEmail(normalizedEmail)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERROR_EMAIL_ALREADY_EXISTS);
        }

        User userToSave = userMapper.toEntity(dto);

        userToSave.setUsername(normalizedUsername);
        userToSave.setEmail(normalizedEmail);
        userToSave.setPassword(passwordEncoder.encode(dto.getPassword()));

        User savedUser = userRepository.save(userToSave);
        return userMapper.toResponseDTO(savedUser);
    }

    public void delete(Integer id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        userRepository.delete(existingUser);
    }

    public UserResponseDTO updateName(Integer id, UpdateNameDTO dto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        if (dto.getName() != null) {
            existingUser.setName(dto.getName());
        }

        userRepository.save(existingUser);
        return userMapper.toResponseDTO(existingUser);
    }

    public UserResponseDTO changeUsername(Integer id, ChangeUsernameDTO dto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        String normalizedUsername = normalizeData(dto.getUsername());
        if (userRepository.existsByUsername(normalizedUsername)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERROR_USERNAME_ALREADY_EXISTS);
        }

        if (!passwordEncoder.matches(dto.getPassword(), existingUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Senha incorreta!");
        }

        existingUser.setUsername(normalizedUsername);
        userRepository.save(existingUser);

        return userMapper.toResponseDTO(existingUser);
    }

    private String normalizeData(String data) {
        return data.toLowerCase().trim();
    }
}