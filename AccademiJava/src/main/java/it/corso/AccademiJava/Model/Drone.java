package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "droni" , schema = "accademi")
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

    // --- COLLEGAMENTO 1 A 1 CON IL DIPENDENTE ---
    @OneToOne
    @JoinColumn(name = "dipendente_id", referencedColumnName = "id")
    private Dipendente responsabile; // Qui usiamo il modello Dipendente
}