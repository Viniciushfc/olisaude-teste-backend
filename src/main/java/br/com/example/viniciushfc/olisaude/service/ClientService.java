package br.com.example.viniciushfc.olisaude.service;

import br.com.example.viniciushfc.olisaude.dto.ClientDTO;
import br.com.example.viniciushfc.olisaude.entities.client.Client;
import br.com.example.viniciushfc.olisaude.infra.exception.NotFoundResourceException;
import br.com.example.viniciushfc.olisaude.infra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClienteRepository clienteRepository;

    //Método utlizado para salvar um client no repository.
    public void saveClient(Client client) {
        this.clienteRepository.save(client);
    }

    //Método para criar um client e salvar um client.
    public Client createClient(ClientDTO dto) {
        Client client = new Client(dto);
        client.setCreationDate(LocalDateTime.now());

        saveClient(client);

        return client;
    }

    //Método para atualizar um client.
    public Client updateClient(Long id, ClientDTO dto) throws Exception {
        Client client = this.clienteRepository.findById(id).orElseThrow(() -> new NotFoundResourceException("Cliente não encontrado!"));

        client.setName(dto.name());
        client.setDateOfBirth(dto.dateOfBirth());
        client.setGenderType(dto.genderType());
        client.setHealthProblem(dto.healthProblem());
        client.setUpdateDate(LocalDateTime.now());

        return client;
    }

    //Método para listar todos os Clients.
    public List<Client> getAllClients() {
        List<Client> clients = this.clienteRepository.findAll();
        return clients;
    }

    //Método para listar um Client específico.
    public Client getClientById(Long id){
        return this.clienteRepository.findById(id).orElseThrow(() -> new NotFoundResourceException("Usuario não encontrado!"));
    }
}
