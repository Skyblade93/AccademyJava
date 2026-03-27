package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {
  //  public ArrayList<Pagamento> findByDataDiPagamento(LocalDateTime dataDiPagamento);

}
