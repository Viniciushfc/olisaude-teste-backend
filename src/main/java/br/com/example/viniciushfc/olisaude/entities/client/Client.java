package br.com.example.viniciushfc.olisaude.entities.client;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity(name = "clients")
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name is mandatory")
    private String name;
    @NotNull(message = "Date Of Birth is mandatory")
    private LocalDateTime dateOfBirth;
    @NotNull(message = "Gender is mandatory")
    private GenderType genderType;
    private HealthProblem healthProblem;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

}
