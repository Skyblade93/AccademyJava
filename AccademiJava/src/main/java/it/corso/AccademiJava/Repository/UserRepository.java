package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {

    User findByNome(String nome);

    @Query("select t from User t where t.nome = ?1")
    User pippo(String nome);

    @Query(value = "SELECT * FROM User t WHERE t.nome = ?1",nativeQuery = true)
    User paperino(String nome);

    void countRecentUsersNative();

    void findByRole(String admin);
}
