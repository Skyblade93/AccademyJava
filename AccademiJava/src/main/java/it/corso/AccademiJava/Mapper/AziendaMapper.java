package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.AziendaDto;
import it.corso.AccademiJava.Model.Azienda;
import org.modelmapper.ModelMapper;


// Classe che gestisce la conversione tra l'entità Azienda e il DTO AziendaDto
public class AziendaMapper extends AbstractConverter<Azienda, AziendaDto> {

    // Istanza di ModelMapper utilizzata per mappare automaticamente campi con lo stesso nome
    final private ModelMapper mapper = new ModelMapper();

    // Converte un'entità Azienda in DTO AziendaDto
    // ModelMapper copia automaticamente tutti i campi che hanno lo stesso nome e tipo
    @Override
    public AziendaDto toDTO(Azienda entity){ return mapper.map(entity, AziendaDto.class); }

    // Converte un DTO AziendaDto in entità Azienda
    // Anche qui, ModelMapper gestisce automaticamente il mapping dei campi
    @Override
    public Azienda toEntity(AziendaDto dto) { return mapper.map(dto, Azienda.class); }

}