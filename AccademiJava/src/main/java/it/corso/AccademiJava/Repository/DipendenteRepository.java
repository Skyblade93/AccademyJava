package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente,Integer> {

    // Metodo 1 Cerca per nome e cognome
    Dipendente findByNomeDipendenteAndCognomeDipendente(String nomeDipendente, String cognomeDipendente);

    // Metodo 1 Cerca per nome, cognome e numero di telefono
    Dipendente findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono(String nomeDipendente, String cognomeDipendente, Integer numeroTelefono);

    // Metodo 1 Cerca dipendenti con età maggiore di ...
    List<Dipendente> findByEtaGreaterThan(Integer eta);

    // Metodo 1 Cerca per età
    List<Dipendente> findByEta(Integer eta);

    // Metodo 1 Cerca per email
    Dipendente findByEmail(String email);

    // Metodo 1 cerca per email ed età
    Dipendente findByEmailAndEta(String email, Integer eta);

    // Metodo 2 cerca per nome ed età  ERRORE
    @Query("select d from Dipendente d where d.nomeDipendente = ?1 and d.eta = ?2")
    Dipendente findByNomeDipendenteAndEta(String nomeDipendente, Integer eta);

    // Metodo 2 cerca per cognome dipendente
    @Query("select d from Dipendente d where d.cognomeDipendente = ?1")
    Dipendente findByCognomeDipendente(String cognomenomeDipendente);

    // Metodo 3 creca per nome dipendente
    // 🔹 QUERY NATIVE (come metodo 3)
    @Query(value = "SELECT * FROM accademi.dipendente d WHERE d.nome_dipendente = ?1", nativeQuery = true)
    Dipendente findByNomeDipendente(String nomeDipendente);

    // Metodo 3 cerca per email ed numero di telefono
    @Query(value = "SELECT * FROM accademi.dipendente d WHERE d.email = ?1 AND d.numero_telefono = ?2", nativeQuery = true)
    Dipendente findByEmailAndNumeroTelefono(String email, Integer numeroTelefono);
}