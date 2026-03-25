package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    // 🔹 Metodo 1 - query automatica (Spring Data)

    // Cerca per nome e cognome
    Contact findByFirstNameAndLastName(String firstName, String lastName);

    // Cerca per email
    Contact findByEmail(String email);

    // Cerca per telefono
    Contact findByPhoneNumber(String phoneNumber);

    // Cerca per nome
    List<Contact> findByFirstName(String firstName);

    // Cerca per cognome
    List<Contact> findByLastName(String lastName);

    // 🔹 Metodo 2 - JPQL

    @Query("SELECT c FROM Contact c WHERE c.firstName = ?1 AND c.email = ?2")
    Contact findByNameAndEmail(String firstName, String email);

    @Query("SELECT c FROM Contact c WHERE c.lastName = ?1")
    List<Contact> findByLastNameQuery(String lastName);

    // 🔹 Metodo 3 - Query Native

    @Query(value = "SELECT * FROM contact c WHERE c.email = ?1", nativeQuery = true)
    Contact findByEmailNative(String email);

    @Query(value = "SELECT * FROM contact c WHERE c.phone_number = ?1", nativeQuery = true)
    Contact findByPhoneNative(String phoneNumber);
}
