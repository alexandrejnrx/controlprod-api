package br.com.alexandrejnrx.controlprodapi.service;

import br.com.alexandrejnrx.controlprodapi.dto.client.ClientCreateRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.client.ClientResponseDTO;
import br.com.alexandrejnrx.controlprodapi.dto.mapper.client.ClientMapper;
import br.com.alexandrejnrx.controlprodapi.exception.ClientNotFoundException;
import br.com.alexandrejnrx.controlprodapi.model.Client;
import br.com.alexandrejnrx.controlprodapi.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientResponseDTO> findAll() {
        return clientRepository.findAll()
                .stream().
                map(clientMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void create(ClientCreateRequestDTO newClient) {
        Client clientToSave = clientMapper.toEntity(newClient);

        clientRepository.save(clientToSave);
    }

    public void delete(Integer id) {
        Client clientToDelete = findById(id);

        clientRepository.delete(clientToDelete);
    }

    private Client findById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(ClientNotFoundException::new);
    }
}
