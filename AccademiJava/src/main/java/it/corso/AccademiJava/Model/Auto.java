package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Auto", schema = "Accademi")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modello;

    private String marca;

    private String targa;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}