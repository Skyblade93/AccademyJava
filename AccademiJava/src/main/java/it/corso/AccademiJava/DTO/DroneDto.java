package it.corso.AccademiJava.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DroneDto {

    private Integer id;
    private String codiceSeriale;
    private String modello;
    private Integer livelloBatteria;
    private Double caricoMassimoKg;
    private String stato;
    private Boolean sensoreOstacoli;

    // QUESTA È LA "JOIN" DATA-LEVEL PER IL DTO:
    // Non usiamo annotazioni @JoinColumn, ma portiamo i dati che servono
    private Integer idResponsabile;
    private String nomeResponsabile;
}