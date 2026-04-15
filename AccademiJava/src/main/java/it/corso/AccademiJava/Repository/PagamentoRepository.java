package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.MetodoPagamento;
import it.corso.AccademiJava.Model.Pagamento;
import it.corso.AccademiJava.Model.StatoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {
    List<Pagamento> findByDataPagamento(LocalDateTime dataPagamento);
    List<Pagamento> findByStato(StatoPagamento stato);

    List<Pagamento> findByMetodo(MetodoPagamento metodo);

    List<Pagamento> findByUserId(Integer userId);
    List<Pagamento> findByImporto(Double importo);
    List<Pagamento>findByStatoAndMetodo(StatoPagamento stato, MetodoPagamento metodo);

    @Query("SELECT p FROM Pagamento p WHERE p.importo > ?1")
    List<Pagamento> findByImportoMaggioreDi(Double importo);
    @Query("SELECT p FROM Pagamento p WHERE p.dataPagamento BETWEEN :inizio AND :fine")
    List<Pagamento> findPagamentiInPeriodo(@Param("inizio") LocalDateTime inizio, @Param("fine") LocalDateTime fine);
    @Query("SELECT p FROM Pagamento p WHERE p.user.id = :userId AND p.stato = :stato")
    List<Pagamento> findByUserIdAndStato(@Param("userId") Integer userId, @Param("stato") StatoPagamento stato);
    @Query("SELECT p FROM Pagamento p WHERE p.importo BETWEEN :min AND :max")
    List<Pagamento> findByImportoBetween(@Param("min") Double min, @Param("max") Double max);
}
