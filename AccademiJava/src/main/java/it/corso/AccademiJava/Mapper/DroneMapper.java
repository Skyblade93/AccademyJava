package it.corso.AccademiJava.Mapper;


import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Model.Drone;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DroneMapper extends AbstractConverter<Drone, DroneDto> {

    private ModelMapper modelMapper; // definiamo la libreria

    // Trasforma Entity -> DTO in modo automatico
    @Override
    public DroneDto toDTO (Drone entity) {
        return modelMapper.map(entity, DroneDto.class);
    }

    // Trasforma DTO -> Entity in modo automatico
    @Override
    public Drone toEntity(DroneDto dto) {
        return modelMapper.map(dto, Drone.class);
    }


    }


