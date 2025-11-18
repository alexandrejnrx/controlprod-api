package br.com.alexandrejnrx.controlprodapi.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private Integer id;
    private String name;
    private String username;
    private String email;

}
