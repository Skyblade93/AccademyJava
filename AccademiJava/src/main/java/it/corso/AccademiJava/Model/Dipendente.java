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
@Table(name = "dipendente", schema = "Accademi")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeDipendente;
    private String cognomeDipendente;
    private Integer eta;
    private String email;
    private Integer numeroTelefono; //posso mettere String se si vuole mettere ad esempio + 39
}
