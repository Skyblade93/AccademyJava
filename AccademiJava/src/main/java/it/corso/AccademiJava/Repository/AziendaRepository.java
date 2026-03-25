package it.corso.AccademiJava.Repository;


import it.corso.AccademiJava.Model.Azienda;
import it.corso.AccademiJava.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Integer> {

    // 1. Trova aziende per nome azienda
    Azienda findByNomeAzienda(String nomeAzienda);

    // 2. Trova aziende per descrizione
    Azienda findByDescrizioneAzienda(String descrizioneAzienda);

    // 3. Trova aziende per titolare
    Azienda findByTitolare(User titolare);

    // 4. Trova aziende che contengono una parola nel nome
    List<Azienda> findByNomeAziendaContaining(String parola);

    // 5. Trova aziende che iniziano con una parola
    List<Azienda> findByNomeAziendaStartingWith(String prefisso);

    // 6. Trova aziende ordinate per nome
    List<Azienda> findAllByOrderByNomeAziendaAsc();



    // 7. Trova azienda per nome azienda
    @Query("select a from Azienda a where a.nomeAzienda = ?1")
    Azienda CercaPerNome(String nome);

    // 8. Trova aziende per descrizione
    @Query("select a from Azienda a where a.descrizioneAzienda = ?1")
    Azienda CercaPerDescrizione(String descrizione);

    // 9. Query native per nome azienda
    @Query(value = "SELECT * FROM azienda a WHERE a.nome_azienda = ?1", nativeQuery = true)
    Azienda TrovaPerNomeNative(String nome);

    // 10. Query native per descrizione
    @Query(value = "SELECT * FROM azienda a WHERE a.descrizione_azienda = ?1", nativeQuery = true)
    Azienda TrovaPerDescrizioneNative(String descrizione);
}
