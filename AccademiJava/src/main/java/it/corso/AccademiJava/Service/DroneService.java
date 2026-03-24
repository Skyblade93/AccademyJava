package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Mapper.DroneMapper;
import it.corso.AccademiJava.Model.Drone;
import it.corso.AccademiJava.Repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private DroneMapper droneMapper;

    // METODO PER SALVARE UN DRONE
    public DroneDto salvaDrone(DroneDto dto) {
        // Trasformo il DTO in Entity
        Drone entity = droneMapper.toEntity(dto);

        // Salvo nel DB
        Drone savedEntity = droneRepository.save(entity);

        // Ritorno il DTO convertito
        return droneMapper.toDto(savedEntity);
    }
    // METODO PER RECUPERARE TUTTI I DRONI
    public List<DroneDto> getAllDroni() {
        // Recupero la lista dal DB
        List<Drone> entities = droneRepository.findAll();

        // Converto la lista in DTO e la ritorno (Senza il cast (DroneDto)!)
        return entities.stream()
                .map(droneMapper::toDto)
                .toList();
    }
}