package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.Model.Carrello;

import java.util.ArrayList;
import java.util.List;

public class CarrelloMapper {

    public List<CarrelloDto> toDtoList(List<Carrello> carrelli){
        List<CarrelloDto> carrelliDtos = new ArrayList<>();
        carrelli.forEach(carrello -> carrelliDtos.add(toDto(carrello)));
        return carrelliDtos;
    }

    public List<Carrello> toEnityList(List<CarrelloDto> carrelliDtos){
        List<Carrello> carrelli = new ArrayList<>();
        carrelliDtos.forEach(carrelloDto -> carrelli.add(toEnity(carrelloDto)));
        return carrelli;
    }

    public CarrelloDto toDto(Carrello carrello) {
        CarrelloDto carrelloDto = new CarrelloDto();

        carrelloDto.setId(carrello.getId());
        carrelloDto.setQuantita(carrello.getQuantita());
        carrelloDto.setPrezzoTotale(carrello.getPrezzoTotale());

        return carrelloDto;
    }

    public Carrello toEnity(CarrelloDto carrelloDto) {
        Carrello carrello = new Carrello();

        carrello.setId(carrelloDto.getId());
        carrello.setQuantita(carrelloDto.getQuantita());
        carrello.setPrezzoTotale(carrelloDto.getPrezzoTotale());

        return carrello;
    }
}

