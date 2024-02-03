package br.com.example.viniciushfc.olisaude.controller;

import br.com.example.viniciushfc.olisaude.dto.ClientDTO;
import br.com.example.viniciushfc.olisaude.entities.client.Client;
import br.com.example.viniciushfc.olisaude.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    //Endpoint para criar um Client.
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO dto) {
        Client client = this.clientService.createClient(dto);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    //Endpoint para atualizar um Client.
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody ClientDTO dto) throws Exception {
        Client client = this.clientService.updateClient(id, dto);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    //Endpoint para buscar um client específico.
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = this.clientService.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    //Endpoint para buscar todos os clients.
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = this.clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    //Endpoint para buscar top 10 pessoas com grau de doença mais alto.
    @GetMapping("/clients/top-10-health-risk")
    public ResponseEntity<List<Client>> getTop10ClientsWithHighestHealthRisk() {
        List<Client> top10Clients = clientService.getTop10ClientsWithHighestHealthRisk();
        return ResponseEntity.ok(top10Clients);
    }
}
