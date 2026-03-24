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
@Table(name = "azienda", schema = "Accademi")
public class Azienda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // identificatore azienda

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User Titolare; // nome del titolare dell'azienda

    private String NomeAzienda; //nome dell'azienda

    private String DescrizioneAzienda; // descrizione del ruolo che svolge l'azienda


}
