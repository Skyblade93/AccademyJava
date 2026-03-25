package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.Mapper.DroneMapper;
import it.corso.AccademiJava.Model.Drone;
import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Repository.DroneRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService extends AbstractService<Drone, DroneDto> {

    private final DroneRepository droneRepository;
    private final UserRepository userRepository;

    public DroneService(DroneRepository droneRepository,
                        DroneMapper droneMapper,
                        UserRepository userRepository) {

        super(droneRepository, droneMapper);
        this.droneRepository = droneRepository;
        this.userRepository = userRepository;
    }

    public List<Drone> cercaDroniPerModello(String modello) {
        return droneRepository.findByModello(modello);
    }
}