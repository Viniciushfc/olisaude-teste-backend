package br.com.example.viniciushfc.olisaude.entities.client;

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
    private String name;
    private Integer degree;
}
