package br.com.example.viniciushfc.olisaude.infra.repository;

import br.com.example.viniciushfc.olisaude.entities.healthProblem.HealthProblem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthProblemRepository extends JpaRepository<HealthProblem, Long> {
}
