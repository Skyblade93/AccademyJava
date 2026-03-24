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

    private Integer id;

    private User Titolare;

    private String NomeAzienda;

    private String DescrizioneAzienda;


}
