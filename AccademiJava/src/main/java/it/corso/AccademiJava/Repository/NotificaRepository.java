package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Notifica;
import it.corso.AccademiJava.Model.PrioritaNotifica;
import it.corso.AccademiJava.Model.TipoNotifica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificaRepository extends JpaRepository<Notifica, Integer> {

    Notifica findByTitolo(String titolo);
    List<Notifica> findByTipo(TipoNotifica tipo);
    List<Notifica> findByPriorita(PrioritaNotifica priorita);
    List<Notifica> findByLetta(Boolean letta);

    @Query("SELECT n FROM Notifica n WHERE n.titolo = ?1 AND n.tipo = ?2")
    List<Notifica> findByTitoloAndTipo(String titolo, TipoNotifica tipo);

    @Query("SELECT n FROM Notifica n WHERE n.dataCreazione > ?1")
    List<Notifica> findByDataCreazioneAfter(LocalDateTime data);

    @Query(value = "SELECT * FROM Notifica WHERE messaggio LIKE %?1%", nativeQuery = true)
    List<Notifica> findByMessaggioContaining(String messaggio);

    @Query(value = "SELECT * FROM Notifica WHERE letta = ?1", nativeQuery = true)
    List<Notifica> findByLettaNative(Boolean letta);

    @Query(value = "SELECT * FROM Notifica WHERE data_creazione > ?1", nativeQuery = true)
    List<Notifica> findByDataCreazioneAfterNative(LocalDateTime data);

    List<Notifica> findByTitoloContaining(String titolo);
    List<Notifica> findByTipoAndPriorita(TipoNotifica tipo, PrioritaNotifica priorita);
}
