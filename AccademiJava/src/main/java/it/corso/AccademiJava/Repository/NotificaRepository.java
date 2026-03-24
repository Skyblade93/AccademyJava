package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Notifica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificaRepository extends JpaRepository<Notifica, Integer> {
}

