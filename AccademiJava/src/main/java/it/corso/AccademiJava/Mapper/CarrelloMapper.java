package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Model.Carrello;
import it.corso.AccademiJava.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/*
public class CarrelloMapper {

    @Autowired
    private UserMapper userMapper;

    public List<CarrelloDto> toDtoList(List<Carrello> carrelli){
        List<CarrelloDto> carrelliDtos = new ArrayList<>();
        carrelli.forEach(carrello -> carrelliDtos.add(toDto(carrello)));
        return carrelliDtos;
    }

    public List<Carrello> toEnityList(List<CarrelloDto> carrelliDtos){
        List<Carrello> carrelli = new ArrayList<>();
        carrelliDtos.forEach(carrelloDto -> carrelli.add(toEntity(carrelloDto)));
        return carrelli;
    }

    public CarrelloDto toDto(Carrello carrello) {
        CarrelloDto carrelloDto = new CarrelloDto();

        carrelloDto.setId(carrello.getId());
        carrelloDto.setQuantita(carrello.getQuantita());
        carrelloDto.setPrezzoTotale(carrello.getPrezzoTotale());
        carrelloDto.setUser(userMapper.toDTO(carrello.getUser()));

        return carrelloDto;
    }

    public Carrello toEntity(CarrelloDto carrelloDto) {
        Carrello carrello = new Carrello();

        carrello.setId(carrelloDto.getId());
        carrello.setQuantita(carrelloDto.getQuantita());
        carrello.setPrezzoTotale(carrelloDto.getPrezzoTotale());
        carrello.setUser(userMapper.toEntity(carrelloDto.getUser()));

        return carrello;
    }
}
 */

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
