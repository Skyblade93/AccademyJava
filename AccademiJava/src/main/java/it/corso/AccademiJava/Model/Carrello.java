package it.corso.AccademiJava.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Carrello", schema = "Accademi")
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double prezzoTotale;

    private Integer quantita;

    @OneToOne //collegamento ad user one to one
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

}