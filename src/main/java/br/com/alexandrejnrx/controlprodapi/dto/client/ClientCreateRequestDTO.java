package br.com.alexandrejnrx.controlprodapi.dto.client;

import br.com.alexandrejnrx.controlprodapi.model.ClientType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientCreateRequestDTO {

    @Column(nullable = false, length = 50)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "client_type", nullable = false, length = 10)
    private ClientType clientType;
    @Column(nullable = false)
    private Boolean active;
}
