package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_product", schema = "Accademi")
public class UserProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relazione con User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Relazione con Product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}