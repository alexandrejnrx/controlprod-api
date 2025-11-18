package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.mapper.user.UserMapper;
import br.com.alexandrejnrx.controlprodapi.dto.user.UserCreateRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.user.UserResponseDTO;
import br.com.alexandrejnrx.controlprodapi.exception.UserEmailAlreadyRegisteredException;
import br.com.alexandrejnrx.controlprodapi.exception.UserNotFoundException;
import br.com.alexandrejnrx.controlprodapi.exception.UserUsernameAlreadyRegisteredException;
import br.com.alexandrejnrx.controlprodapi.model.User;
import br.com.alexandrejnrx.controlprodapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void create(UserCreateRequestDTO newUser) {
        if (userRepository.existsByUsername(newUser.getUsername())) {
            throw new UserUsernameAlreadyRegisteredException();
        }

        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new UserEmailAlreadyRegisteredException();
        }

        User userToSave = userMapper.toEntity(newUser);
        userToSave.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(userToSave);
    }

    public void deleteById(Integer id) {
        User existingUser = findById(id);

        userRepository.delete(existingUser);
    }

    public void updateName(Integer id, String newName) {
        User existingUser = findById(id);

        existingUser.setName(newName);
        userRepository.save(existingUser);
    }

    public void updateUsername(Integer id, String newUsername) {
        User existingUser = findById(id);

        if (userRepository.existsByUsername(newUsername)) {
            throw new UserUsernameAlreadyRegisteredException();
        }

        existingUser.setUsername(newUsername);
        userRepository.save(existingUser);
    }

    public void updateEmail(Integer id, String newEmail) {
        User existingUser = findById(id);

        if (userRepository.existsByEmail(newEmail)) {
            throw new UserEmailAlreadyRegisteredException();
        }

        existingUser.setEmail(newEmail);
        userRepository.save(existingUser);
    }

    private User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}