package br.com.alexandrejnrx.controlprodapi.dto.converter;

import br.com.alexandrejnrx.controlprodapi.dto.usuario.UserRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.usuario.UserResponseDTO;
import br.com.alexandrejnrx.controlprodapi.model.User;

public class UserConverter {

    public static User converterDTOParaEntidade(UserRequestDTO userRequestDTO) {
        User user = new User();

        user.setName(userRequestDTO.getName());
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(userRequestDTO.getRole());

        return user;
    }

    public static UserResponseDTO converterEntidadeParaDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setName(user.getName());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setEmail(user.getEmail());

        return userResponseDTO;
    }
}
