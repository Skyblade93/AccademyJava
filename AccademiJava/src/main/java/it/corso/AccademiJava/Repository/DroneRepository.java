package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

    // --- 5 QUERY BASIC (DERIVATE) ---
    // 1. Cerca per modello
    List<Drone> findByModello(String modello);

    // 2. Filtra per batteria superiore a un valore
    List<Drone> findByLivelloBatteriaGreaterThan(int soglia);

    // 3. Filtra per stato operativo
    List<Drone> findByStato(String stato);

    // 4. Trova droni con sensore attivo
    List<Drone> findBySensoreOstacoliTrue();

    // 5. Cerca per modello e stato insieme
    List<Drone> findByModelloAndStato(String modello, String stato);


    // --- 5 QUERY NATIVE (SQL PURO) ---
    // 6. I 5 droni più scarichi (Usa LIMIT di SQL)
    @Query(value = "SELECT * FROM droni ORDER BY livello_batteria ASC LIMIT 5", nativeQuery = true)
    List<Drone> findTop5LowBatteryNative();

    // 7. Ricerca parziale sul seriale (Usa LIKE di SQL)
    @Query(value = "SELECT * FROM droni WHERE codice_seriale LIKE %:keyword%", nativeQuery = true)
    List<Drone> searchBySerialNative(@Param("keyword") String keyword);

    // 8. Conta quanti droni sono "Pronti" (Batteria > 80)
    @Query(value = "SELECT COUNT(*) FROM droni WHERE livello_batteria > 80", nativeQuery = true)
    long countReadyDronesNative();

    // 9. Seleziona droni pesanti con sensori attivi
    @Query(value = "SELECT * FROM droni WHERE carico_massimo_kg > 10 AND sensore_ostacoli = true", nativeQuery = true)
    List<Drone> findHeavyDronesNative();

    // 10. Seleziona droni per una specifica missione (Esempio SQL)
    @Query(value = "SELECT * FROM droni WHERE stato = 'AVAILABLE' AND livello_batteria > 20", nativeQuery = true)
    List<Drone> findDronesForMissionNative();

   // void findTop5FlownDronesNative();
}
