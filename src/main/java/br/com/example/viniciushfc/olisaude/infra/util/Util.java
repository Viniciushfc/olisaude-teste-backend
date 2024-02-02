package br.com.example.viniciushfc.olisaude.infra.util;

import br.com.example.viniciushfc.olisaude.dto.HealthProblemDTO;
import br.com.example.viniciushfc.olisaude.entities.client.Client;
import br.com.example.viniciushfc.olisaude.entities.healthProblem.HealthProblem;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {

    public void checkIllness(Client client) {
        if (client.getHealthProblem() == null) {
            HealthProblemDTO dto = new HealthProblemDTO("Não possui nenhuma doenção", -1);
            HealthProblem healthProblem = new HealthProblem(dto);
            client.setHealthProblem(healthProblem);
        }
    }
}
