package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.converter.UserMapper;
import br.com.alexandrejnrx.controlprodapi.dto.user.ChangeUsernameDTO;
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

    public void create(UserCreateRequestDTO newUser) {
        if (userRepository.existsByUsername(newUser.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERROR_USERNAME_ALREADY_EXISTS);
        }

        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERROR_EMAIL_ALREADY_EXISTS);
        }

        User userToSave = userMapper.toEntity(newUser);
        userToSave.setPassword(passwordEncoder.encode(newUser.getPassword()));

        userRepository.save(userToSave);
    }

    public void deleteById(Integer id) {
        User existingUser = findUserById(id);

        userRepository.delete(existingUser);
    }

    public void updateName(Integer id, String newName) {
        User existingUser = findUserById(id);

        if (newName != null) {
            existingUser.setName(newName);
        }

        userRepository.save(existingUser);
    }

    public void changeUsername(Integer id, ChangeUsernameDTO dto) {
        User existingUser = findUserById(id);

        if (userRepository.existsByUsername(dto.getNewUsername().toLowerCase().trim())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERROR_USERNAME_ALREADY_EXISTS);
        }

        if (!passwordEncoder.matches(dto.getPassword(), existingUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Senha incorreta!");
        }

        existingUser.setUsername(dto.getNewUsername().toLowerCase().trim());
        userRepository.save(existingUser);
    }

    private User findUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}