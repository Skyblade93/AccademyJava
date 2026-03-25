package it.corso.AccademiJava.DTO;

import it.corso.AccademiJava.Model.Contact;
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


}
