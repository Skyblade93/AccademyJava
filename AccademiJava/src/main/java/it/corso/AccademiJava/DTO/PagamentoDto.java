package it.corso.AccademiJava.DTO;

import it.corso.AccademiJava.Model.MetodoPagamento;
import it.corso.AccademiJava.Model.StatoPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDto {
    private Integer id;
    private Double importo;
    private LocalDateTime dataPagamento;
    private StatoPagamento stato;
    private MetodoPagamento metodo;

}
