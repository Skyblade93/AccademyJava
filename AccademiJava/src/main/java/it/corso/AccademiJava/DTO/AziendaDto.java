package it.corso.AccademiJava.DTO;

import it.corso.AccademiJava.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AziendaDto {

    private Integer id; // identificatore azienda

    private UserDto titolare; // nome del titolare dell'azienda

    private String nomeAzienda; //nome dell'azienda

    private String descrizioneAzienda; // descrizione del ruolo che svolge l'azienda

    private AutoDto auto;

    private ElettricistaDto elettricisti;
}
