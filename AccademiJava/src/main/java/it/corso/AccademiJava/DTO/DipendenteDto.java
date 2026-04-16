package it.corso.AccademiJava.DTO;

import it.corso.AccademiJava.Model.Auto;
import it.corso.AccademiJava.Model.Azienda;
import it.corso.AccademiJava.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteDto {

    private Integer id;                 // identificativo del dipendente
    private String nomeDipendente;      // nome del dipendente
    private String cognomeDipendente;   // cognome del dipendente
    private Integer eta;                // età del dipendente
    private String email;               // email del dipendente
    private Integer numeroTelefono;     // numero di telefono del dipendente
    /*
    private AziendaDto nomeAzienda;     // Nome dell'azienda dove lavora il dipendente
    private UserDto user;               // Utenza collegata al dipendente
    private ContactDto contact;         // Informazioni di contatto del dipendente
    private DroneDto drone;             // Un dipendente ha un UNICO drone
    private List<AutoDto> auto;         // Un dipendente può avere più di un'auto
    */

}
