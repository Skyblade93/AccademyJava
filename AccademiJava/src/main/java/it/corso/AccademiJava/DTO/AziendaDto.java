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

    private UserDto Titolare; // nome del titolare dell'azienda

    private String NomeAzienda; //nome dell'azienda

    private String DescrizioneAzienda; // descrizione del ruolo che svolge l'azienda


}
