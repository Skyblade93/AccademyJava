package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.NotificaDto;
import it.corso.AccademiJava.Model.PrioritaNotifica;
import it.corso.AccademiJava.Model.TipoNotifica;
import it.corso.AccademiJava.Service.NotificaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("Notifica")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificaController extends AbstractController<NotificaDto> {

    @Autowired
    private NotificaService service;

    @GetMapping("/FindByTitolo")
    public NotificaDto FindByTitolo(@RequestParam("titolo") String titolo) {
        return service.FindByTitolo(titolo);
    }

    @GetMapping("/CountMessaggioLength")
    public Integer CountMessaggioLength(@RequestParam("titolo") String titolo) {
        return service.CountMessaggioLength(titolo);
    }

    @GetMapping("/FindByTipo")
    public List<NotificaDto> FindByTipo(@RequestParam("tipo") TipoNotifica tipo) {
        return service.FindByTipo(tipo);
    }

    @GetMapping("/FindByPriorita")
    public List<NotificaDto> FindByPriorita(@RequestParam("priorita") PrioritaNotifica priorita) {
        return service.FindByPriorita(priorita);
    }

    @GetMapping("/FindByLetta")
    public List<NotificaDto> FindByLetta(@RequestParam("letta") Boolean letta) {
        return service.FindByLetta(letta);
    }

    @GetMapping("/FindByTitoloAndTipo")
    public List<NotificaDto> FindByTitoloAndTipo(@RequestParam("titolo") String titolo,
                                                 @RequestParam("tipo") TipoNotifica tipo) {
        return service.FindByTitoloAndTipo(titolo, tipo);
    }

    @GetMapping("/FindByDataCreazioneAfter")
    public List<NotificaDto> FindByDataCreazioneAfter(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime data) {
        return service.FindByDataCreazioneAfter(data);
    }

    @GetMapping("/FindByMessaggioContaining")
    public List<NotificaDto> FindByMessaggioContaining(@RequestParam("messaggio") String messaggio) {
        return service.FindByMessaggioContaining(messaggio);
    }

    @GetMapping("/FindByLettaNative")
    public List<NotificaDto> FindByLettaNative(@RequestParam("letta") Boolean letta) {
        return service.FindByLettaNative(letta);
    }

    @GetMapping("/FindByDataCreazioneAfterNative")
    public List<NotificaDto> FindByDataCreazioneAfterNative(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime data) {
        return service.FindByDataCreazioneAfterNative(data);
    }

    @GetMapping("/FindByTitoloContaining")
    public List<NotificaDto> FindByTitoloContaining(@RequestParam("titolo") String titolo) {
        return service.FindByTitoloContaining(titolo);
    }

    @GetMapping("/FindByTipoAndPriorita")
    public List<NotificaDto> FindByTipoAndPriorita(@RequestParam("tipo") TipoNotifica tipo,
                                                   @RequestParam("priorita") PrioritaNotifica priorita) {
        return service.FindByTipoAndPriorita(tipo, priorita);
    }
}
