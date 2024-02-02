package br.com.example.viniciushfc.olisaude.entities.healthProblem;

import br.com.example.viniciushfc.olisaude.dto.HealthProblemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "healthProblems")
@Table(name = "healthProblems")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diseaseName;
    private Integer degree;

    public HealthProblem(HealthProblemDTO dto) {
        this.diseaseName = dto.diseaseName();
        this.degree = dto.degree();
    }

}
