package it.corso.AccademiJava.DTO;

import it.corso.AccademiJava.Model.Drone;
import it.corso.AccademiJava.Model.PrioritaNotifica;
import it.corso.AccademiJava.Model.TipoNotifica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificaDto {

    private Integer id;

    private String titolo;

    private String messaggio;

    private TipoNotifica tipo;

    private PrioritaNotifica priorita;

    private LocalDateTime dataCreazione;

    private Boolean letta;

    private Drone drone;
}

