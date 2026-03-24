package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.AziendaDto;
import it.corso.AccademiJava.Model.Azienda;

public class AziendaMapper {



    public AziendaDto toDto(Azienda azienda){
        AziendaDto aziendaDto = new AziendaDto();

        aziendaDto.setId(azienda.getId());
        aziendaDto.setTitolare(azienda.getTitolare());
        aziendaDto.setNomeAzienda(azienda.getNomeAzienda());
        aziendaDto.setDescrizioneAzienda(azienda.getDescrizioneAzienda());


        return aziendaDto;
    }

    public Azienda toEntity(AziendaDto aziendaDto){
        Azienda azienda = new Azienda();

        azienda.setId(aziendaDto.getId());
        azienda.setTitolare(aziendaDto.getTitolare());
        azienda.setNomeAzienda(aziendaDto.getNomeAzienda());
        azienda.setDescrizioneAzienda(aziendaDto.getDescrizioneAzienda());


        return azienda;
    }

}
