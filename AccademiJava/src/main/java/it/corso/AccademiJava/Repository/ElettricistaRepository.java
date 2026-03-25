package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Elettricista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElettricistaRepository extends JpaRepository<Elettricista, Integer> {

    // 1 JPA AUT
    Elettricista findByNome(String nome);

    // 2 JPA AUT
    List<Elettricista> findByDisponibileTrue();

    // 3 JPA AUT
    List<Elettricista> findByCognome(String cognome);

    // 4 JPA AUT
    List<Elettricista> findBySpecializzazione(String specializzazione);

    // 5 JPQL
    @Query("select e from Elettricista e where e.nome = ?1")
    Elettricista cercaPerNomeJPQL(String nome);

    // 6 JPQL
    @Query("select e from Elettricista e where e.disponibile = true")
    List<Elettricista> elettricistiDisponibiliJPQL();

    // 7 NAT
    @Query(value = "SELECT * FROM elettricista WHERE nome = ?1", nativeQuery = true)
    Elettricista findByNomeNative(String nome);

    // 8 NAT
    @Query(value = "SELECT * FROM elettricista WHERE disponibile = true", nativeQuery = true)
    List<Elettricista> findDisponibiliNative();

    // 9 JPA AUT
    List<Elettricista> findByCognomeAndDisponibileTrue(String cognome);

    // 10 JPA AUT
    List<Elettricista> findBySpecializzazioneAndDisponibileFalse(String specializzazione);
}