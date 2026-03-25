package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

    // Metodo standard corretto (Spring lo riconosce automaticamente)
    Optional<Drone> findById(Long id);

    // --- QUERY DERIVATE ---
    List<Drone> findByModello(String modello);
    List<Drone> findByLivelloBatteriaGreaterThan(int soglia);
    List<Drone> findByStato(String stato);
    List<Drone> findBySensoreOstacoliTrue();
    List<Drone> findByModelloAndStato(String modello, String stato);

    // --- QUERY NATIVE ---
    @Query(value = "SELECT * FROM droni ORDER BY livello_batteria ASC LIMIT 5", nativeQuery = true)
    List<Drone> findTop5LowBatteryNative();

    @Query(value = "SELECT * FROM droni WHERE codice_seriale LIKE %:keyword%", nativeQuery = true)
    List<Drone> searchBySerialNative(@Param("keyword") String keyword);

    @Query(value = "SELECT COUNT(*) FROM droni WHERE livello_batteria > 80", nativeQuery = true)
    long countReadyDronesNative();

    @Query(value = "SELECT * FROM droni WHERE carico_massimo_kg > 10 AND sensore_ostacoli = true", nativeQuery = true)
    List<Drone> findHeavyDronesNative();

    @Query(value = "SELECT * FROM droni WHERE stato = 'AVAILABLE' AND livello_batteria > 20", nativeQuery = true)
    List<Drone> findDronesForMissionNative();
}