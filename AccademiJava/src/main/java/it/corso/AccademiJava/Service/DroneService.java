package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.Repository.DroneRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DroneService extends AbstractService {

    @Autowired
    private DroneRepository droneRepository; // Variabile minuscola

    @Autowired
    private UserRepository userRepository;   // Variabile minuscola
/*
    public void eseguiOperazioniDedicate() {
        // 1. Usiamo userRepository (minuscolo!) per le query User
        userRepository.findByRole("ADMIN");
        userRepository.countRecentUsersNative();

        // 2. Usiamo droneRepository (minuscolo!) per le query Drone
        droneRepository.findByLivelloBatteriaGreaterThan(50);
        droneRepository.findTop5FlownDronesNative();

        System.out.println("Tutte le query dei repository dedicati sono state richiamate con successo!");
    }
    */

}