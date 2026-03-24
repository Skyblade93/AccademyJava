package it.corso.AccademiJava.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
