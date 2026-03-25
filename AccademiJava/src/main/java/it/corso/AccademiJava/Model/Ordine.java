package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinTable(
            name = "ordini_product",
            joinColumns = @JoinColumn(name = "ordine_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;


}
