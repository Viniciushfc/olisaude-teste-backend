package br.com.example.viniciushfc.olisaude.service;

import br.com.example.viniciushfc.olisaude.dto.ClientDTO;
import br.com.example.viniciushfc.olisaude.entities.client.Client;
import br.com.example.viniciushfc.olisaude.entities.healthProblem.HealthProblem;
import br.com.example.viniciushfc.olisaude.infra.exception.NotFoundResourceException;
import br.com.example.viniciushfc.olisaude.infra.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    //Método utlizado para salvar um client no repository.
    public void saveClient(Client client) {
        this.clientRepository.save(client);
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
        Client client = this.clientRepository.findById(id).orElseThrow(() -> new NotFoundResourceException("Cliente não encontrado!"));

        client.setName(dto.name());
        client.setDateOfBirth(dto.dateOfBirth());
        client.setGenderType(dto.genderType());
        client.setHealthProblem(dto.healthProblem());
        client.setUpdateDate(LocalDateTime.now());

        saveClient(client);

        return client;
    }

    //Método para listar todos os Clients.
    public List<Client> getAllClients() {
        List<Client> clients = this.clientRepository.findAll();
        return clients;
    }

    //Método para listar um Client específico.
    public Client getClientById(Long id) {
        return this.clientRepository.findById(id).orElseThrow(() -> new NotFoundResourceException("Usuario não encontrado!"));
    }

    //Método para listar os top10 mais graves.
    public List<Client> getTop10ClientsWithHighestHealthRisk() {
        List<Client> allClients = clientRepository.findAll();

        // Ordenar os clientes com base no risco de saúde em ordem decrescente
        List<Client> sortedClients = allClients.stream()
                .sorted(Comparator.comparingDouble(this::calculateHealthRiskScore).reversed())
                .limit(10)
                .collect(Collectors.toList());

        return sortedClients;
    }

    //Método para fazer o calculo para os score das doenças.
    private double calculateHealthRiskScore(Client client) {
        int healthProblemDegreeSum = client.getHealthProblem().getDegree();
        return (1 / (1 + Math.exp(-(-2.8 + healthProblemDegreeSum)))) * 100;
    }

}
