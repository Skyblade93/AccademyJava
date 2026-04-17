package it.corso.AccademiJava.Repository;


import it.corso.AccademiJava.Model.Azienda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Integer> {

    // 1. Trova aziende per nome azienda
    Azienda findByNomeAzienda(String nomeAzienda);

    // 2. Ricerca per nome contenente parola (case-insensitive)
    List<Azienda> findByNomeAziendaContainingIgnoreCase(String parola);

    // 3. Trova aziende per descrizione
    List<Azienda> findByDescrizioneAziendaContainingIgnoreCase(String descrizioneAzienda);

    // 4. Trova aziende per titolare
    Azienda findByTitolare_Id(Integer titolare);

    // 5. Trova aziende che contengono una parola nel nome
    List<Azienda> findByNomeAziendaContaining(String parola);

    // 6. Trova aziende che iniziano con una parola
    List<Azienda> findByNomeAziendaStartingWith(String prefisso);

    // 7. Trova aziende ordinate per nome
    List<Azienda> findAllByOrderByNomeAziendaAsc();



    // 8. Trova azienda per nome azienda
    @Query("select a from Azienda a where a.nomeAzienda = ?1")
    Azienda CercaPerNome(String nome);

    // 9. Trova aziende per descrizione
    @Query("select a from Azienda a where a.descrizioneAzienda = ?1")
    List<Azienda> CercaPerDescrizione(String descrizione);

    // 10. Query native per nome azienda
    @Query(value = "SELECT * FROM azienda a WHERE a.nome_azienda = ?1", nativeQuery = true)
    Azienda TrovaPerNomeNative(String nome);

    // 11. Query native per descrizione
    @Query(value = "SELECT * FROM azienda a WHERE a.descrizione_azienda = ?1", nativeQuery = true)
    List<Azienda> TrovaPerDescrizioneNative(String descrizione);

    Page<Azienda> findAll(Pageable pageable);
}
