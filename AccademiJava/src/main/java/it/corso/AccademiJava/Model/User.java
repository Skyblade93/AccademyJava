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
@Table(name = "User", schema = "Accademi")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //identificativo dell user

    private String name; // nome dell user

    private String description; //descrizione dell user

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Carrello carrello;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Product> products;
}
