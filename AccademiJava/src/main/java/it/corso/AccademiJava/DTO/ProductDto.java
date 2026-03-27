package it.corso.AccademiJava.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id; //codice prodotto
    private String name; //nome prodotto
    private Double price; //prezzo mostrato
    private Integer quantity; //quantità disponibili
    private String category; //tipo di oggetto
    private List<OrdineProduct> ordini; //collegamento con OrdineProduct
}