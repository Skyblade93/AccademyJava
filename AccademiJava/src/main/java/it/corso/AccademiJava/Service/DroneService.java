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
        // Passiamo repo e mapper alla classe base AbstractService
        super(droneRepository, droneMapper);
        this.droneRepository = droneRepository;
        this.userRepository = userRepository;
    }

    // Metodo per cercare un drone per modello
    public DroneDto findByModello(String modello) {
        Drone entity = (Drone) droneRepository.findByModello(modello);
        // Usiamo il cast (DroneMapper) per accedere al metodo toDTO che hai appena scritto
        return ((DroneMapper) converter).toDTO(entity);
    }

    // Metodo per cercare i droni tramite l'iniziale
    public List<DroneDto> trovaTramiteIniziale(Character i) {
        List<Drone> entities = droneRepository.findByModelloStartingWith(String.valueOf(i));
        // Usiamo il metodo toDtoList che hai nel tuo Mapper
        return ((DroneMapper) converter).toDtoList(entities);
    }
}