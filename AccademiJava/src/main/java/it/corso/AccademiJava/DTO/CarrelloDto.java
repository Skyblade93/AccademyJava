package it.corso.AccademiJava.DTO;

import it.corso.AccademiJava.Model.Contact;
import it.corso.AccademiJava.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarrelloDto {

    private Integer id; //identificativo carrello

    private Double prezzoTotale;

    private Integer quantita;

    private User user; //collegamento ad user

}