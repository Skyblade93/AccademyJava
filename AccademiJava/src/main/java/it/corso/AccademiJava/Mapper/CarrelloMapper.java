package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.Model.Carrello;
import org.modelmapper.ModelMapper;

public class CarrelloMapper extends AbstractConverter<Carrello, CarrelloDto> {


    final private ModelMapper mapper = new ModelMapper();


    @Override
    public CarrelloDto toDTO(Carrello entity) {
        return mapper.map(entity, CarrelloDto.class);
    }

    @Override
    public Carrello toEntity(CarrelloDto dto) {
        return mapper.map(dto, Carrello.class);
    }
}
