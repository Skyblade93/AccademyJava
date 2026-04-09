package it.corso.AccademiJava.Model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Auto", schema = "Accademi")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //identificativo auto

    private String modello;  //modello dell'auto

    private String marca;  //marca dell'auto

    @Column(nullable = false, unique = true)
    private String targa;  //targa dell'auto

    @Enumerated(EnumType.STRING) // salva il nome dell'enum nel DB
    private TipoCarburante carburante; //tipo carburante

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "azienda_id", nullable = true)
    private Azienda azienda;

    @ManyToOne
    @JoinColumn(name = "dipendete_id", nullable = true)
    private Dipendente dipendente;
}