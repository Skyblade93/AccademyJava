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
    private Integer id;  //collegato all'id di user che autoincrementato già

    private String modello;  //modello dell'auto

    private String marca;  //marca dell'auto

    private String targa;  //targa dell'auto

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}