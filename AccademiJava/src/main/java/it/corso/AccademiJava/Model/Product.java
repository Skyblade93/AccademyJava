package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "Product", schema = "Accademi")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private Integer quantity;

    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //Relazione ManytoMany con Entity Ordine
    @ManyToMany(mappedBy = "prodotti")
    private List<Ordine> ordini;
}