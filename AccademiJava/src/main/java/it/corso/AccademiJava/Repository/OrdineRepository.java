package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Ordine;
import it.corso.AccademiJava.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdineRepository  extends JpaRepository<Ordine,Integer> {

    Ordine FindById(Integer id);
    List<Ordine> FindByCosto_totale(float costo);

    @Query("select t from Ordine t where t.numero_prodotti > ?1")
    List<Ordine> trovaConNumeroProdottiMaggiore(Integer numero);

    @Query("select t from Ordine t where t.indirizzo_spedizione = ?1")
    List<Ordine> trovaConIndirizzo(String indirizzo);

    @Query("select t from Ordine t where t.costo_totale > ?1")
    List<Ordine> trovaConCostoMaggiore(float costo);

    @Query("select t from Ordine t where t.costo_totale < ?1")
    List<Ordine> trovaConCostoMinore(float costo);

    @Query(value = "SELECT * FROM Ordine t WHERE t.utente = ?1",nativeQuery = true)
    List<Ordine> trovaPerUtente(User utente);

    @Query(value = "SELECT * FROM ordine WHERE numero_prodotti > ?1 AND costo_totale < ?2", nativeQuery = true)
    List<Ordine> filtro(Integer numero, float costo);

    @Query(value = "SELECT * FROM ordine ORDER BY costo_totale DESC", nativeQuery = true)
    List<Ordine> ordinaPerCostoDecrescente();

    @Query(value = "SELECT * FROM ordine WHERE costo_totale BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Ordine> trovaTraDueCosti(float min, float max);
}
