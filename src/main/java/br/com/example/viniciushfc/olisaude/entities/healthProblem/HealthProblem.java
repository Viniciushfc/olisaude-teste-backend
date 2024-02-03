package br.com.example.viniciushfc.olisaude.entities.healthProblem;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class HealthProblem {
    private String diseaseName;
    private Integer degree;

}
