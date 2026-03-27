package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.PagamentoDto;
import it.corso.AccademiJava.Service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("pagamento")
@CrossOrigin(origins="http://localhost:4200")// accetta da questa porta (porta angular)

public class PagamentoController extends AbstractController<PagamentoDto> {
    @Autowired
    private PagamentoService pagamentoService; //inietto il mio servizio;
/*
    @GetMapping("/findByDataDiPagamento")
    public List<PagamentoDto> findByDataDiPagamento(@RequestParam("nome") LocalDateTime data){
        return pagamentoService.findByDataDiPagamento(data);

    }

 */
}
