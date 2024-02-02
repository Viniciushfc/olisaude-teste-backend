package br.com.example.viniciushfc.olisaude.infra.repository;

import br.com.example.viniciushfc.olisaude.entities.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Client, Long> {
}
