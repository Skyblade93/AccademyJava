package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Ordine", schema = "Accademi")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float costo_totale;

    private int numero_prodotti;

    private String indirizzo_spedizione;
}
