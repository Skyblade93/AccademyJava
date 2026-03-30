package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.PagamentoDto;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Mapper.PagamentoMapper;
import it.corso.AccademiJava.Model.MetodoPagamento;
import it.corso.AccademiJava.Model.Pagamento;
import it.corso.AccademiJava.Model.StatoPagamento;
import it.corso.AccademiJava.Repository.PagamentoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PagamentoService extends AbstractService<Pagamento, PagamentoDto> {

    final private PagamentoMapper pagamentoMapper;
    final private PagamentoRepository pagamentoRepository;

    protected PagamentoService(JpaRepository<Pagamento, Integer> repository, Converter<Pagamento, PagamentoDto> converter, PagamentoMapper pagamentoMapper, PagamentoRepository pagamentoRepository) {
        super(repository, converter);

        this.pagamentoMapper = pagamentoMapper;
        this.pagamentoRepository = pagamentoRepository;
    }
    public List<PagamentoDto> findByDataPagamento(LocalDateTime dataPagamento){
        return pagamentoMapper.toDTOList(pagamentoRepository.findByDataPagamento(dataPagamento));
    }
    public List<PagamentoDto> findByStato(StatoPagamento stato) {
        return pagamentoMapper.toDTOList(pagamentoRepository.findByStato(stato));
    }

    public List<PagamentoDto> findByMetodo(MetodoPagamento metodo) {
        return pagamentoMapper.toDTOList(pagamentoRepository.findByMetodo(metodo));
    }

    public List<PagamentoDto> findByUserId(Integer userId) {
        return pagamentoMapper.toDTOList(pagamentoRepository.findByUserId(userId));
    }

    public List<PagamentoDto> findByImporto(Double importo) {
        return pagamentoMapper.toDTOList(pagamentoRepository.findByImporto(importo));
    }
    public List<PagamentoDto> findByImportoMaggioreDi(Double importo) {
        return pagamentoMapper.toDTOList(pagamentoRepository.findByImportoMaggioreDi(importo));
    }
}
