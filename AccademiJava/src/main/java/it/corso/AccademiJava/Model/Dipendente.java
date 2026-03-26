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
@Table(name = "dipendente", schema = "accademi")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // identificativo del dipendente

    @Column(length=30,nullable=false)
    private String nomeDipendente; // nome del dipendente

    @Column(length=30,nullable=false)
    private String cognomeDipendente; // cognome del dipendente

    @Column(length=3,nullable=false)
    private Integer eta; // età del dipendente

    @Column(length=30,nullable=false)
    private String email; // email del dipendente

    @Column(length=15,nullable=false)
    private Integer numeroTelefono; //posso mettere String se si vuole mettere ad esempio + 39

    @OneToOne
    @JoinColumn(name = "nomeAzienda")
    private Azienda nomeAzienda; // Nome dell'azienda dove lavora il dipendente

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Utenza collegata al dipendente
}
