package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Model.Drone;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DroneMapper extends AbstractConverter<Drone, DroneDto> {

    private ModelMapper modelMapper = new ModelMapper();

    // Trasforma Entity -> DTO (Attenzione: deve essere toDTO se richiesto dal padre)
    @Override
    public DroneDto toDTO(Drone entity) {
        if (entity == null) return null;
        return modelMapper.map(entity, DroneDto.class);
    }

    // Trasforma DTO -> Entity
    @Override
    public Drone toEntity(DroneDto dto) {
        if (dto == null) return null;
        return modelMapper.map(dto, Drone.class);
    }

    // Metodo per le liste (per il service)
    public List<DroneDto> toDtoList(List<Drone> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}