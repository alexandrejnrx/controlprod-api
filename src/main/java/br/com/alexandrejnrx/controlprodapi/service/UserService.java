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
    private static final String ERROR_USERNAME_ALREADY_EXISTS = "Nome de usuário já cadastrado";
    private static final String ERROR_EMAIL_ALREADY_EXISTS = "E-mail já cadastrado";

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream().
                map(UserConverter::converterEntityToDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO findById(Integer id) {
        return userRepository.findById(id)
                .map(UserConverter::converterEntityToDTO)
                .orElseThrow(() -> new UserNotFoundException());
    }

    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        String normalizedUsername = normalizeData(userRequestDTO.getUsername());
        String normalizedEmail = normalizeData(userRequestDTO.getEmail());

        if (userRepository.existsByUsername(normalizedUsername)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERROR_USERNAME_ALREADY_EXISTS);
        }

        if (userRepository.existsByEmail(normalizedEmail)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ERROR_EMAIL_ALREADY_EXISTS);
        }

        User userToSave = UserConverter.converterDTOToEntity(userRequestDTO);

        userToSave.setUsername(normalizedUsername);
        userToSave.setEmail(normalizedEmail);
        userToSave.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));

        User savedUser = userRepository.save(userToSave);
        return UserConverter.converterEntityToDTO(savedUser);
    }

    public void delete(Integer id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        userRepository.delete(existingUser);
    }

    public UserResponseDTO update(Integer id, UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        if (userRequestDTO.getName() != null) {
            existingUser.setName(userRequestDTO.getName());
        }

        if (userRequestDTO.getUsername() != null) {
            String normalizedUsername = normalizeData(userRequestDTO.getUsername());

            if (!existingUser.getUsername().equals(normalizedUsername)) {
                existingUser.setUsername(normalizedUsername);
            }
        }

        if (userRequestDTO.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        }

        User updatedUser = userRepository.save(existingUser);
        return UserConverter.converterEntityToDTO(updatedUser);
    }

    private String normalizeData(String data) {
        return data.toLowerCase().trim();
    }
}