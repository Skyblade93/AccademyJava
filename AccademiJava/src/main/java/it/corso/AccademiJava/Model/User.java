package it.corso.AccademiJava.Model;


import it.corso.AccademiJava.Controller.UserController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "Accademi")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //identificativo dell user

    private String name; // nome dell user

    private String description; //descrizione dell user
    /*

    @OneToOne(mappedBy = "user")
    private Pagamento pagamento;

    @OneToMany(mappedBy= "user")
    private List<Auto> auto;

    @OneToMany(mappedBy = "user")
    private List<UserProduct> userProducts;

     */
}
