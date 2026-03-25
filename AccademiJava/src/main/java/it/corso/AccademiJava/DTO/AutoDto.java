package it.corso.AccademiJava.DTO;

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

    //user collegato all'auto
    private User user;
}
