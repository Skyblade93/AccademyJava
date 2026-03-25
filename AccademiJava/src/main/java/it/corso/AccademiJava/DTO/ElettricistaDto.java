package it.corso.AccademiJava.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElettricistaDto {

    private Integer id; // id elettricista
    private String nome; // nome elettricista
    private String cognome; // cognome elettricista
    private String specializzazione; // specializzazione elettricista
    private Boolean disponibile; // disponibilità elettricista
}