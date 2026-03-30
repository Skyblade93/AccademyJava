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
    // 1. Ricerca per Stato e Metodo
    @GetMapping("/findByStatoAndMetodo")
    public List<PagamentoDto> findByStatoAndMetodo(
            @RequestParam("stato") StatoPagamento stato,
            @RequestParam("metodo") MetodoPagamento metodo) {
        return pagamentoService.findByStatoAndMetodo(stato, metodo);
    }

    // 2. Ricerca in un periodo di tempo
    @GetMapping("/findPagamentiInPeriodo")
    public List<PagamentoDto> findPagamentiInPeriodo(
            @RequestParam("inizio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inizio,
            @RequestParam("fine") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fine) {
        return pagamentoService.findPagamentiInPeriodo(inizio, fine);
    }

    // 3. Ricerca per Utente e Stato
    @GetMapping("/findByUserIdAndStato")
    public List<PagamentoDto> findByUserIdAndStato(
            @RequestParam("userId") Integer userId,
            @RequestParam("stato") StatoPagamento stato) {
        return pagamentoService.findByUserIdAndStato(userId, stato);
    }

    // 4. Ricerca per Range di Importo (quella extra che abbiamo aggiunto)
    @GetMapping("/findByImportoBetween")
    public List<PagamentoDto> findByImportoBetween(
            @RequestParam("min") Double min,
            @RequestParam("max") Double max) {
        return pagamentoService.findByImportoBetween(min, max);
    }
    }

