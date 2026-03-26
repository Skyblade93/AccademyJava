package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Auto;
import it.corso.AccademiJava.Model.TipoCarburante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {

    //  1. QUERY JPQL
    @Query("SELECT a FROM Auto a WHERE a.targa = :targa")
    Auto findByTarga(@Param("targa") String targa);

    //  METODI DERIVATI
    List<Auto> findByMarca(String marca);

    // 1
    Optional<Auto> findById(Integer id);

    // 2
    List<Auto> findByModello(String modello);

    // 3
    List<Auto> findByMarcaAndModello(String marca, String modello);

    // 4
    List<Auto> findByModelloContaining(String modello);

    // 5
    List<Auto> findByMarcaStartingWith(String marca);

    // 6
    List<Auto> findByMarcaEndingWith(String marca);

    // metodi per carburante
    List<Auto> findByCarburante(TipoCarburante carburante);

    List<Auto> findByMarcaAndCarburante(String marca, TipoCarburante carburante);
}