package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.AziendaDto;
import it.corso.AccademiJava.Model.Azienda;

import java.util.ArrayList;
import java.util.List;

public class AziendaMapper extends AbstractConverter<Azienda, AziendaDto> {

    public List<AziendaDto> toDtoList(List<Azienda> azienda) {
        List<AziendaDto> aziendaDtos = new ArrayList<>();
        azienda.forEach(aziendas -> aziendaDtos.add(toDTO(aziendas)));
        return aziendaDtos;
    }

    public List<Azienda> toEntityList(List<AziendaDto> aziendaDto) {
        List<Azienda> azienda = new ArrayList<>();
        aziendaDto.forEach(aziendaDtos -> azienda.add(toEntity(aziendaDtos)));
        return azienda;
    }

    @Override
    public AziendaDto toDTO(Azienda azienda){
        AziendaDto aziendaDto = new AziendaDto();

        aziendaDto.setId(azienda.getId());
        aziendaDto.setTitolare(azienda.getTitolare());
        aziendaDto.setNomeAzienda(azienda.getNomeAzienda());
        aziendaDto.setDescrizioneAzienda(azienda.getDescrizioneAzienda());


        return aziendaDto;
    }

    @Override
    public Azienda toEntity(AziendaDto aziendaDto){
        Azienda azienda = new Azienda();

        azienda.setId(aziendaDto.getId());
        azienda.setTitolare(aziendaDto.getTitolare());
        azienda.setNomeAzienda(aziendaDto.getNomeAzienda());
        azienda.setDescrizioneAzienda(aziendaDto.getDescrizioneAzienda());


        return azienda;
    }

}
