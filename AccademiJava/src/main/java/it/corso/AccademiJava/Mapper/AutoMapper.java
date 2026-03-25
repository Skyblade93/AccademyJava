package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.AutoDto;
import it.corso.AccademiJava.Model.Auto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AutoMapper extends AbstractConverter<Auto, AutoDto> {


    //modelmapper usato per mappare automaticamente
    final private ModelMapper mapper = new ModelMapper();

    // converte entità Auto in DTO AutoDto
    @Override
    public AutoDto toDTO(Auto entity) { return mapper.map(entity, AutoDto.class); }

    //converte DTO AutoDto in entità Auto
    @Override
    public Auto toEntity(AutoDto dto) { return mapper.map(dto, Auto.class);} }