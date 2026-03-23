package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prodotti" ,schema="Accademi")
public class Prodotto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    @Column(length=30,nullable=false)
    private String nomeProdotto;
    @Column(length=30,nullable=false)
    private String descrizione;





}
