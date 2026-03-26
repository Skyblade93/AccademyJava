package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product", schema = "Accademi")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private Integer quantity;

    private String category;


    @ManyToMany(mappedBy = "products")
    private List<Ordine> ordini;

    @OneToMany(mappedBy = "product")
    private List<UserProduct> userProducts;
/*

    @ManyToMany(mappedBy = "products")
    private List<Ordine> ordini;
*/
}