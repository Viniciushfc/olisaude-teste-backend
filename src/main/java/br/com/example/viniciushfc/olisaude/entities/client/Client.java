package br.com.example.viniciushfc.olisaude.entities.client;


import br.com.example.viniciushfc.olisaude.dto.ClientDTO;
import br.com.example.viniciushfc.olisaude.entities.healthProblem.HealthProblem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

    public Client(ClientDTO dto) {
        this.name = dto.name();
        this.dateOfBirth = dto.dateOfBirth();
        this.genderType = dto.genderType();
        this.healthProblem = dto.healthProblem();
    }
}
