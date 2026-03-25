package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "droni" , schema = "Accademi")
@Getter
@Setter
@NoArgsConstructor // Aggiunto per evitare l'errore "No default constructor"
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String codiceSeriale; // Es: "DRN-2026-X1"

    private String modello;
    private Integer livelloBatteria; // Da 0 a 100
    private Double caricoMassimoKg;
    private String stato; // Es: "IN_VOLO", "CARICA", "MANUTENZIONE"
    private Boolean sensoreOstacoli;

}