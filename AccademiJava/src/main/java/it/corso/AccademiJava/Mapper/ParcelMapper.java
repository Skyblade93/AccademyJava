package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.ParcelDto;
import it.corso.AccademiJava.Model.Parcel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ParcelMapper extends AbstractConverter<Parcel, ParcelDto> {

    final private ModelMapper mapper = new ModelMapper();

    @Override
    public ParcelDto toDTO(Parcel entity) { return mapper.map(entity, ParcelDto.class); }

    @Override
    public Parcel toEntity(ParcelDto dto) { return mapper.map(dto, Parcel.class);}
}