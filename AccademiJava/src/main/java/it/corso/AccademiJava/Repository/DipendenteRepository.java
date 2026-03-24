package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente,Integer> {
}
