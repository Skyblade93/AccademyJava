package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente,Integer> {

    // Metodo 1

    // Cerca per nome e cognome
    Dipendente findByNomeDipendenteAndCognomeDipendente(String nome, String cognome);

    // Cerca per nome, cognome e numero di telefono
    Dipendente findByNomeAndCognomeAndNumber(String nome, String cognome, Integer numeroTelefono);

    // Cerca dipendenti con età maggiore di ...
    List<Dipendente> findByEtaGreaterThan(Integer eta);

    // Cerca per età
    List<Dipendente> findByEta(Integer eta);

    // Cerca per email
    Dipendente findByEmail(String email);

    // cerca per email ed età
    Dipendente findByEmailAndEta(String email, Integer eta);

    // Metodo 2 cerca per nome ed età
    @Query("select d from Dipendente d where d.nomeDipendente = ?1 and d.eta = ?2")
    Dipendente findByNomeAndEta(String nomeDipendente, Integer eta);

    // Metodo 2 cerca per cognome dipendente
    @Query("select d from Dipendente d where d.cognomeDipendente = ?1")
    Dipendente findByCognome(String cognomenomeDipendente);

    // Metodo 3 creca per nome dipendente
    // 🔹 QUERY NATIVE (come metodo 3)
    @Query(value = "SELECT * FROM dipendente d WHERE d.nome_dipendente = ?1", nativeQuery = true)
    Dipendente findByNome(String nomeDipendente);

    // Metodo 3 cerca per email ed numero di telefono
    @Query(value = "SELECT * FROM dipendente d WHERE d.email = ?1 AND d.numero_telefono = ?2", nativeQuery = true)
    Dipendente findByEmailAndNumber(String email, Integer numeroTelefono);
}