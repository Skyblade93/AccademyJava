package it.corso.AccademiJava.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String codiceSeriale; // Es: "DRN-2026-X1"
    private String modello;
    private Integer livelloBatteria; // Da 0 a 100
    private Double caricoMassimoKg;
    private String stato; // Es: "IN_VOLO", "CARICA", "MANUTENZIONE"
    private Boolean sensoreOstacoli;

}

