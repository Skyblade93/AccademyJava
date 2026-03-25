package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.ElettricistaDto;
import it.corso.AccademiJava.Model.Elettricista;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

// Mapper basic
@Component
public class ElettricistaMapper extends AbstractConverter<Elettricista, ElettricistaDto> {

    // ModelMapper fa conv.auto con Entity e DTO
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public ElettricistaDto toDTO(Elettricista entity) {
        // Converte entity Elettricista in DTO auto
        return mapper.map(entity, ElettricistaDto.class);
    }

    @Override
    public Elettricista toEntity(ElettricistaDto dto) {
        // Converte DTO ElettricistaDto in entity
        return mapper.map(dto, Elettricista.class);
    }
}