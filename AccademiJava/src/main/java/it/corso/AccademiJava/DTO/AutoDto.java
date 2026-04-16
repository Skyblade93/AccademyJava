package it.corso.AccademiJava.DTO;

import it.corso.AccademiJava.Model.Azienda;
import it.corso.AccademiJava.Model.Dipendente;
import it.corso.AccademiJava.Model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutoDto {

    //id auto
    private Integer id;

    private String modello;

    private String marca;

    private String targa;

    private String carburante;

    //user collegato all'auto
    private UserDto user;
    //azienda collegata
    private AziendaDto azienda;
    //dipendente collegato
    private DipendenteDto dipendente;
}
