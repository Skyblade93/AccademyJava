package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Mapper.DroneMapper;
import it.corso.AccademiJava.Model.Drone;
import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Repository.DroneRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService<DroneDto> extends AbstractService<Drone, DroneDto> {

    private final DroneRepository droneRepository;
    private final UserRepository userRepository;

    public DroneService(DroneRepository droneRepository,
                        DroneMapper droneMapper,
                        UserRepository userRepository) {
        // Passiamo repository e mapper al costruttore della classe padre (AbstractService)
        super((JpaRepository<Drone, Integer>) droneRepository, (Converter<Drone, DroneDto>) droneMapper);
        this.droneRepository = droneRepository;
        this.userRepository = userRepository;
    }
/*
    // Metodo che restituisce DTO (quello che serve al Controller)
    public <DroneDto> DroneDto findByModello(String modello) {
        // Cerchiamo l'entity tramite il nome del modello
        Drone entity = droneRepository.findByModelloCustom(modello);
        // Usiamo il 'converter' ereditato da AbstractService per trasformarlo in DTO
        return converter.toDto(entity);
    }
*/

}