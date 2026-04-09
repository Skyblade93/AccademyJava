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
@Table(name = "azienda", schema = "Accademi")
public class Azienda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // identificatore azienda

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User titolare; // nome del titolare dell'azienda

    private String nomeAzienda; //nome dell'azienda

    private String descrizioneAzienda; // descrizione del ruolo che svolge l'azienda

    @OneToMany(mappedBy = "azienda")
    private List<Auto> auto;

    @ManyToMany
    @JoinTable(
            name = "azienda_elettricista",
            joinColumns = @JoinColumn(name = "azienda_id"),
            inverseJoinColumns = @JoinColumn(name = "elettricista_id")
    )
    private List<Elettricista> elettricisti;


}
