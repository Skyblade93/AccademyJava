package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Dice a Spring che questa è la porta d'accesso al Database
public interface DroneRepository extends JpaRepository<Drone, Integer> {

}