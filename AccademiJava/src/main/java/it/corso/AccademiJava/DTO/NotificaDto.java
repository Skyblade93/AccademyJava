package it.corso.AccademiJava.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataCreazione;

    private Boolean letta;

    private DroneDto drone;

    private UserDto user;
}
