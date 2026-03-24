package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Carrello;
import it.corso.AccademiJava.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello,Integer> {

    Carrello findById(int id);

    @Query("select t from Carrello t where t.id = ?1")
    Carrello cercaPerId(int id);

    @Query(value = "SELECT * FROM Carrello t WHERE t.id = ?1",nativeQuery = true)
    Carrello cercaPerIdNative(int id);

    Carrello findByQuantita(Integer quantita);

    @Query("select t from Carrello t where t.quantita = ?1")
    Carrello cercaPerQuantita(int quantita);

    @Query(value = "SELECT * FROM Carrello t WHERE t.quantita = ?1",nativeQuery = true)
    Carrello cercaPerQuantitaNative(int quantita);

    Carrello findByPrezzoTotale(double prezzoTotale);

    @Query("select t from Carrello t where t.prezzoTotale = ?1")
    Carrello cercaPerPrezzoTotale(double prezzoTotale);

    @Query(value = "SELECT * FROM Carrello t WHERE t.prezzoTotale = ?1",nativeQuery = true)
    Carrello cercaPrezzoTotaleNative(double prezzoTotale);

}
