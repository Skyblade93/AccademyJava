package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.Mapper.DroneMapper;
import it.corso.AccademiJava.Model.Drone;
import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Repository.DroneRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // 1. Corretto: findByModello restituisce una lista nel repository
    public DroneDto findByModello(String modello) {
        List<Drone> entities = droneRepository.findByModello(modello);
        if (entities.isEmpty()) {
            return null;
        }
        // Prendiamo il primo drone trovato e lo trasformiamo in DTO
        return ((DroneMapper) converter).toDTO(entities.get(0));
    }

    // 2. Corretto: Gestione della lista tramite il mapper
    public List<DroneDto> trovaTramiteIniziale(Character i) {
        List<Drone> entities = droneRepository.findByModelloStartingWith(String.valueOf(i));
        return ((DroneMapper) converter).toDtoList(entities);
    }

    // 3. Aggiunto: Implementazione del findById usando la classe base o il repo
    @Override
    public DroneDto findById(Integer id) {
        Optional<Drone> entity = droneRepository.findById(id);
        return entity.map(drone -> ((DroneMapper) converter).toDTO(drone)).orElse(null);
    }
}