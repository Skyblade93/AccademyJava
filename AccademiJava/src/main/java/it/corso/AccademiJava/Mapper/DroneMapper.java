package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Model.Drone;
import it.corso.AccademiJava.Model.User;
import org.springframework.stereotype.Component;

// @Component dice a Spring che questa classe è un "Bean".
// Significa che Spring la creerà all'avvio e potremo usarla con @Autowired ovunque.
@Component
public class DroneMapper extends AbstractConverter<Drone, DroneDto> {

    // Trasforma l'oggetto del Database (Entity) in oggetto per il Web (DTO)
    @Override
    public DroneDto toDto(Drone entity) {
        // Controllo di sicurezza: se l'entity è nulla, restituisco null per evitare errori (NullPointerException)
        if (entity == null) return null;

        // Creo un nuovo contenitore vuoto (DTO)
        DroneDto dto = new DroneDto();

        // Copio i dati uno per uno dall'Entity al DTO
        dto.setId(entity.getId());
        dto.setCodiceSeriale(entity.getCodiceSeriale());
        dto.setModello(entity.getModello());
        dto.setLivelloBatteria(entity.getLivelloBatteria());
        dto.setCaricoMassimoKg(entity.getCaricoMassimoKg());
        dto.setStato(entity.getStato());
        dto.setSensoreOstacoli(entity.getSensoreOstacoli());

        // Restituisco il DTO pronto per essere inviato al Frontend (es: un'app o una pagina web)
        return dto;
    }

    //  Trasforma l'oggetto che arriva dal Web (DTO) in oggetto per il Database (Entity)
    @Override
    public Drone toEntity(DroneDto dto) {
        // Controllo di sicurezza
        if (dto == null) return null;

        // Creo una nuova Entity (quella che Hibernate salverà sul DB)
        Drone entity = new Drone();

        // Copio i dati dal DTO all'Entity
        entity.setId(dto.getId());
        entity.setCodiceSeriale(dto.getCodiceSeriale());
        entity.setModello(dto.getModello());
        entity.setLivelloBatteria(dto.getLivelloBatteria());
        entity.setCaricoMassimoKg(dto.getCaricoMassimoKg());
        entity.setStato(dto.getStato());
        entity.setSensoreOstacoli(dto.getSensoreOstacoli());

        // Restituisco l'Entity pronta per essere passata al Repository e salvata
        return entity;
    }

    @Override
    public DroneDto toDTO(Drone drone) {
        return null;
    }

    @Override
    public UserDto toDto(User user) {
        return null;
    }

    @Override
    public User toEnity(UserDto userDto) {
        return null;
    }
}