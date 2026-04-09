package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {

    User findByName(String nome);

    @Query("select t from User t where t.name = ?1")
    User pippo(String nome);

    @Query(value = "SELECT * FROM User t WHERE t.name = ?1",nativeQuery = true)
    User paperino(String nome);

    @Query("select w from User w where w.name like concat(?1, '%')")
    List<User> trovaTramiteiniziale(Character i);

    User findByDescription(String description);
}
