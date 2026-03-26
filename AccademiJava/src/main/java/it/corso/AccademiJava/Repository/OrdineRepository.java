package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Ordine;
import it.corso.AccademiJava.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdineRepository  extends JpaRepository<Ordine, Integer> {

 //   Ordine findById(int id);
 //   List<Ordine> findByCosto_totale(float costo);

    @Query("select t from Ordine t where t.numero_prodotti > ?1")
    List<Ordine> trovaConNumeroProdottiMaggiore(Integer numero);

    @Query("select t from Ordine t where t.indirizzo_spedizione = ?1")
    List<Ordine> trovaConIndirizzo(String indirizzo);

    @Query("select t from Ordine t where t.costo_totale > ?1")
    List<Ordine> trovaConCostoMaggiore(float costo);

    @Query("select t from Ordine t where t.costo_totale < ?1")
    List<Ordine> trovaConCostoMinore(float costo);

    @Query("select o from Ordine o where o.numero_prodotti > ?1 and o.costo_totale < ?2")
    List<Ordine> filtro(Integer numero_prodotti, float costo_totale);

    @Query(value = "select o from Ordine o where o.utente = ?1")
    List<Ordine> trovaPerUtente(Integer id);

    @Query(value = "SELECT * FROM accademi.ordine ORDER BY costo_totale DESC", nativeQuery = true)
    List<Ordine> ordinaPerCostoDecrescente();

    @Query(value = "SELECT * FROM accademi.ordine WHERE costo_totale BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Ordine> trovaTraDueCosti(float min, float max);
}
