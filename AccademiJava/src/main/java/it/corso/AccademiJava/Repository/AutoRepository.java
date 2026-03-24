package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Auto;
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
    Auto trovaPerTargaJPQL(@Param("targa") String targa);

    //  2. QUERY NATIVE
    @Query(value = "SELECT * FROM auto WHERE marca = :marca", nativeQuery = true)
    List<Auto> trovaPerMarcaNative(@Param("marca") String marca);

    //  METODI DERIVATI (8)

    // 1
    Optional<Auto> findById(Integer id);

    // 2
    Auto findByTarga(String targa);

    // 3
    List<Auto> findByModello(String modello);

    // 4
    List<Auto> findByMarca(String marca);

    // 5
    List<Auto> findByMarcaAndModello(String marca, String modello);

    // 6
    List<Auto> findByModelloContaining(String modello);

    // 7
    List<Auto> findByMarcaStartingWith(String marca);

    // 8
    List<Auto> findByMarcaEndingWith(String marca);
}