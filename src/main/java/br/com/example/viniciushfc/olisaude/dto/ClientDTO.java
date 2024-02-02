package br.com.example.viniciushfc.olisaude.dto;


import br.com.example.viniciushfc.olisaude.entities.client.GenderType;
import br.com.example.viniciushfc.olisaude.entities.healthProblem.HealthProblem;

import java.time.LocalDateTime;

public record ClientDTO(String name, LocalDateTime dateOfBirth, GenderType genderType, HealthProblem healthProblem) {
}
