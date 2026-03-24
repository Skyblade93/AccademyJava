package it.corso.AccademiJava.Mapper;



import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Model.Drone;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<Entity,DTO> implements Converter<Entity,DTO> {

    public List<Entity> toEntityList(Iterable<DTO> listDTO) {
        List<Entity> list = new ArrayList<Entity>();

        if (listDTO != null) {
            for (DTO dto : listDTO) {
                Entity entity = toEntity(dto);
                list.add(entity);
            }
        }
        return list;
    }

    public List<DTO> toDTOList(Iterable<Entity> listEntity) {
        List<DTO> list = new ArrayList<DTO>();

        if (listEntity != null) {
            for (Entity entity : listEntity) {
                DTO dto = toDTO(entity);
                list.add(dto);
            }
        }
        return list;
    }


    // Trasforma l'oggetto del Database (Entity) in oggetto per il Web (DTO)
    public abstract DroneDto toDto(Drone entity);
}

