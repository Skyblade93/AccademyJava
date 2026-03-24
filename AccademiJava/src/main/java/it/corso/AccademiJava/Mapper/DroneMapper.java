package it.corso.AccademiJava.Mapper;


import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Model.Drone;
import org.modelmapper.ModelMapper;


public class DroneMapper extends AbstractConverter<Drone, DroneDto> {

    private ModelMapper modelMapper; // Iniettiamo la libreria

    // Trasforma Entity -> DTO in modo automatico
    @Override
    public DroneDto toDTO (Drone entity) {
        // Questa riga fa tutto il lavoro dei setter che avevi prima!
        return modelMapper.map(entity, DroneDto.class);
    }

    // Trasforma DTO -> Entity in modo automatico
    @Override
    public Drone toEntity(DroneDto dto) {
        // Anche qui, ModelMapper accoppia i campi da solo
        return modelMapper.map(dto, Drone.class);
    }


    }


