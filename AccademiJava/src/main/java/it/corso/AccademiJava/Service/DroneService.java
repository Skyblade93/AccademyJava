package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.Model.Drone;
import it.corso.AccademiJava.Repository.DroneRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DroneService extends AbstractService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private UserRepository userRepository;
/*
    public void eseguiOperazioniDedicate() {
        // 1. Esempio operazioni su UserRepository
        userRepository.findByRole("ADMIN");
        userRepository.countRecentUsersNative();

        // 2. Operazioni su DroneRepository (usando i metodi creati prima)

        // Cerca droni con batteria superiore al 50%
        List<Drone> droniCarichi = droneRepository.findByLivelloBatteriaGreaterThan(50);

        // Esegue la query nativa per trovare i droni con batteria bassa
        List<Drone> droniScarichi = droneRepository.findTop5LowBatteryNative();

        System.out.println("Tutte le query dei repository dedicati (User e Drone) sono state richiamate con successo!");
        System.out.println("Droni trovati con batteria > 50%: " + droniCarichi.size());
    }
*/
    // Metodo extra per testare la ricerca per modello che abbiamo scritto nella Repo
    public List<Drone> cercaDroniPerModello(String modello) {
        return droneRepository.findByModello(modello);
    }
}