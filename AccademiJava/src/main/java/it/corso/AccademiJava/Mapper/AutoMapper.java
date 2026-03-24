package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.AutoDTO;
import it.corso.AccademiJava.Model.Auto;
import it.corso.AccademiJava.Model.User;

import java.util.ArrayList;
import java.util.List;

public class AutoMapper {

    public List<AutoDTO> toDtoList(List<Auto> autos){
        List<AutoDTO> autoDtos = new ArrayList<>();
        autos.forEach(auto -> autoDtos.add(toDto(auto)));
        return autoDtos;
    }

    public List<Auto> toEntityList(List<AutoDTO> autoDtos, List<User> users){
        List<Auto> autos = new ArrayList<>();
        for (int i = 0; i < autoDtos.size(); i++) {  // serve l'indice per prendere l'utente corrispondente

            autos.add(toEntity(autoDtos.get(i), users.get(i)));
        }
        return autos;
    }

    public AutoDTO toDto(Auto auto) {
        AutoDTO dto = new AutoDTO();

        dto.setId(auto.getId());
        dto.setModello(auto.getModello());
        dto.setMarca(auto.getMarca());
        dto.setTarga(auto.getTarga());

        // estrae solo l'id dell'userm se esiste
        dto.setUserId(auto.getUser() != null ? auto.getUser().getId() : null);

        return dto;
    }

    public Auto toEntity(AutoDTO dto, User user) {
        Auto auto = new Auto();

        auto.setId(dto.getId());
        auto.setModello(dto.getModello());
        auto.setMarca(dto.getMarca());
        auto.setTarga(dto.getTarga());
        auto.setUser(user); // user già recuperato dal DB nel service

        return auto;
    }
}