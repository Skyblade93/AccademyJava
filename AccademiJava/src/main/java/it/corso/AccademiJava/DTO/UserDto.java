package it.corso.AccademiJava.DTO;

import it.corso.AccademiJava.Model.Auto;
import it.corso.AccademiJava.Model.Contact;
import it.corso.AccademiJava.Model.Pagamento;
import it.corso.AccademiJava.Model.UserProduct;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id; //identificativo dell user

    private String name; // nome dell user

    private String description; //descrizione dell user

    private Pagamento pagamento;

    private List<Auto> auto;

    private List<UserProduct> userProducts;

}
