package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Model.Drone;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DroneMapper extends AbstractConverter<Drone, DroneDto> {

    @Autowired
    private ModelMapper modelMapper; // Iniettiamo la libreria

    // Trasforma Entity -> DTO in modo automatico
    @Override
    public DroneDto toDto(Drone entity) {
        if (entity == null) return null;
        // Questa riga fa tutto il lavoro dei setter che avevi prima!
        return modelMapper.map(entity, DroneDto.class);
    }

    // Trasforma DTO -> Entity in modo automatico
    @Override
    public Drone toEntity(DroneDto dto) {
        if (dto == null) return null;
        // Anche qui, ModelMapper accoppia i campi da solo
        return modelMapper.map(dto, Drone.class);
    }

    // Se l'AbstractConverter o l'interfaccia richiede toDTO (maiuscolo)
    @Override
    public DroneDto toDTO(Drone drone) {
        return toDto(drone);
    }
}