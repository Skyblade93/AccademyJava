package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.OrdineDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Model.Ordine;
import it.corso.AccademiJava.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdineMapper extends AbstractConverter<Ordine,OrdineDto> {

    final private ModelMapper mapper = new ModelMapper();

    @Override
    public OrdineDto toDTO(Ordine entity) { return mapper.map(entity, OrdineDto.class); }

    @Override
    public Ordine toEntity(OrdineDto dto) { return mapper.map(dto, Ordine.class);}
}
