package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.PagamentoDto;
import it.corso.AccademiJava.Model.MetodoPagamento;
import it.corso.AccademiJava.Model.StatoPagamento;
import it.corso.AccademiJava.Service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("pagamento")
@CrossOrigin(origins="http://localhost:4200")// accetta da questa porta (porta angular)

public class PagamentoController extends AbstractController<PagamentoDto> {
    @Autowired
    private PagamentoService pagamentoService; //inietto il mio servizio;
   // @GetMapping("/findByDataPagamento")
   // public List<PagamentoDto> findByDataPagamento(@RequestParam("dataPagamento") LocalDateTime data){
    //    return pagamentoService.findByDataPagamento(data);
   @GetMapping("/findByDataPagamento")
   public List<PagamentoDto> findByDataPagamento(
           @RequestParam("dataPagamento")
           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
           LocalDateTime dataPagamento) {
       return pagamentoService.findByDataPagamento(dataPagamento);
   }
    @GetMapping("/findByStato")
    public List<PagamentoDto> findByStato(@RequestParam("stato") StatoPagamento stato) {
        return pagamentoService.findByStato(stato);
    }
    @GetMapping("/findByMetodo")
    public List<PagamentoDto> findByMetodo(@RequestParam("metodo") MetodoPagamento metodo) {
        return pagamentoService.findByMetodo(metodo);
    }
    @GetMapping("/findByUserId")
    public List<PagamentoDto> findByUserId(@RequestParam("userId") Integer userId) {
        return pagamentoService.findByUserId(userId);
    }
    @GetMapping("/findByImporto")
    public List<PagamentoDto> findByImporto(@RequestParam("importo") Double importo) {
        return pagamentoService.findByImporto(importo);
    }
    @GetMapping("/findByImportoMaggioreDi")
    public List<PagamentoDto> findByImportoMaggioreDi(@RequestParam("importo") Double importo) {
        return pagamentoService.findByImportoMaggioreDi(importo);
    }

    }

