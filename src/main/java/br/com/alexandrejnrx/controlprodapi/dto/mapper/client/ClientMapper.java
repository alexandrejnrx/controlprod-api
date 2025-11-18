package br.com.alexandrejnrx.controlprodapi.dto.mapper.client;

import br.com.alexandrejnrx.controlprodapi.dto.client.ClientResponseDTO;
import br.com.alexandrejnrx.controlprodapi.dto.client.ClientCreateRequestDTO;
import br.com.alexandrejnrx.controlprodapi.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientCreateRequestDTO newClient) {
        Client client = new Client();

        client.setName(newClient.getName());
        client.setClientType(newClient.getClientType());
        client.setActive(newClient.getActive());

        return client;
    }

    public ClientResponseDTO toResponseDTO(Client entity) {
        ClientResponseDTO dto = new ClientResponseDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setClientType(entity.getClientType());
        dto.setActive(entity.getActive());

        return dto;
    }
}
