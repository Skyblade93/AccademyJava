package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "elettricista", schema = "Accademi")
public class Elettricista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome; // Nome dell'elettricista
    private String cognome; // Cognome dell'elettricista
    private String specializzazione; // es.Impianti industriali
    private Boolean disponibile; // True se l'elettricista e disponibile
}