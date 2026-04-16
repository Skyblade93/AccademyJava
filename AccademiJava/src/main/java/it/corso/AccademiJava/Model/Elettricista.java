package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "elettricista", schema = "accademi")
public class Elettricista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cognome;
    private String specializzazione;
    private Boolean disponibile;
    private String telefono;
    private String email;
    private String indirizzo;


    // Collegamento ManyToOne con Drone
    @ManyToOne
    @JoinColumn(name = "drone_id")
    private Drone drone;
}