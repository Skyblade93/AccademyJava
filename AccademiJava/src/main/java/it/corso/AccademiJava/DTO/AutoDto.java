package it.corso.AccademiJava.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoDto {

    private Integer id; //id auto
    private String modello;
    private String marca;
    private String targa;
    private Integer userId; //id user collegato all'auto
}
