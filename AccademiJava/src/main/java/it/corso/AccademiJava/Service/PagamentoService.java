package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.PagamentoDto;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Mapper.PagamentoMapper;
import it.corso.AccademiJava.Model.Pagamento;
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

}
    /*
    public List<PagamentoDto> findByDataDiPagamento(LocalDateTime dataDiPagamento){
        return pagamentoMapper.toDTOList(pagamentoRepository.findByDataDiPagamento(dataDiPagamento));
    }
}
*/