package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
}
