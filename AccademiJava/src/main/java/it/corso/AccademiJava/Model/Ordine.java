package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Ordine", schema = "Accademi")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float costo_totale;

    private Integer numero_prodotti;

    private String indirizzo_spedizione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private User utente;

    @ManyToMany
    private List<Prodotto> prodotti;
}
