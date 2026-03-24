package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.DipendenteDto;
import it.corso.AccademiJava.Model.Dipendente;

import java.util.ArrayList;
import java.util.List;

public class DipendenteMapper {

    public List<DipendenteDto> toDtoList(List<Dipendente> dipendenti){
        List<DipendenteDto> dipendenteDtos = new ArrayList<>();
        dipendenti.forEach(dipendente ->  dipendenteDtos.add(toDto(dipendente)));
        return dipendenteDtos;
    }

    public List<Dipendente> toEnityList(List<DipendenteDto> dipendenteDtos){
        List<Dipendente> dipendenti = new ArrayList<>();
        dipendenteDtos.forEach(dipendenteDto ->  dipendenti.add(toEnity(dipendenteDto)));
        return dipendenti;
    }

    public DipendenteDto toDto(Dipendente dipendente) {
        DipendenteDto dipendenteDto = new DipendenteDto();

        dipendenteDto.setId(dipendente.getId());
        dipendenteDto.setNomeDipendente(dipendente.getNomeDipendente());
        dipendenteDto.setCognomeDipendente(dipendente.getCognomeDipendente());
        dipendenteDto.setEta(dipendente.getEta());
        dipendenteDto.setEmail(dipendente.getEmail());
        dipendenteDto.setNumeroTelefono(dipendente.getNumeroTelefono());

        return dipendenteDto;
    }

    public Dipendente toEnity(DipendenteDto dipendenteDto) {
        Dipendente dipendente = new Dipendente();

        dipendente.setId(dipendenteDto.getId());
        dipendente.setNomeDipendente(dipendenteDto.getNomeDipendente());
        dipendente.setCognomeDipendente(dipendenteDto.getCognomeDipendente());
        dipendente.setEta(dipendenteDto.getEta());
        dipendente.setEmail(dipendenteDto.getEmail());
        dipendente.setNumeroTelefono(dipendenteDto.getNumeroTelefono());

        return dipendente;
    }
}

