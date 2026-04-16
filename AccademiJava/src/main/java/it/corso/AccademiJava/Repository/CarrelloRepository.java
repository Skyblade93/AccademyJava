package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Carrello;
import it.corso.AccademiJava.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello,Integer> {

    // 1
    Carrello findById(int id);

    // QUERY JPQL 2
    @Query("select t from Carrello t where t.quantita = ?1")
    List<Carrello> cercaPerQuantita(int quantita);

    //3
    @Query(value = "SELECT * FROM accademi.carrello WHERE prezzo_totale = ?1", nativeQuery = true)
    List<Carrello> cercaPrezzoTotale(double prezzoTotale);

    // 4
    Carrello findByIdAndQuantita(int Id, int quantita);

    // 5
    Carrello findByIdAndPrezzoTotale(int Id, double prezzoTotale);

    // 6
    List<Carrello> findByQuantitaAndPrezzoTotale(int quantita, double prezzoTotale);

}
