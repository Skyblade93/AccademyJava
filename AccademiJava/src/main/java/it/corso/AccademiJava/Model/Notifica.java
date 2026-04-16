package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notifica", schema = "accademi")
public class Notifica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titolo;

    private String messaggio;

    @Enumerated(EnumType.STRING)
    private TipoNotifica tipo;

    @Enumerated(EnumType.STRING)
    private PrioritaNotifica priorita;

    private LocalDateTime dataCreazione;

    private Boolean letta;

    @ManyToOne
    @JoinColumn(name = "drone_id")
    private Drone drone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;
}

