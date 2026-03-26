package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.ElettricistaDto;
import it.corso.AccademiJava.Service.ElettricistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elettricisti")
public class ElettricistaController {

    @Autowired
    private ElettricistaService elettricistaService;

    // 1 Cerca elettricista per nome
    @GetMapping("/nome/{nome}")
    public ElettricistaDto findByNome(@PathVariable String nome) {
        return elettricistaService.findByNome(nome);
    }

    // 2 prende tutti gli elettricisti disponibili
    @GetMapping("/disponibili")
    public List<ElettricistaDto> findDisponibili() {
        return elettricistaService.findDisponibili();
    }

    // 3 Cerca per cognome
    @GetMapping("/cognome/{cognome}")
    public List<ElettricistaDto> findByCognome(@PathVariable String cognome) {
        return elettricistaService.findByCognome(cognome);
    }

    // 4 Cerca per specializzazione
    @GetMapping("/specializzazione/{spec}")
    public List<ElettricistaDto> findBySpecializzazione(@PathVariable String spec) {
        return elettricistaService.findBySpecializzazione(spec);
    }

    // 5 JPQL es.
    @GetMapping("/jpql/{nome}")
    public ElettricistaDto cercaPerNomeJPQL(@PathVariable String nome) {
        return elettricistaService.cercaPerNomeJPQL(nome);
    }

    // 6 Lista disponibili con JPQL
    @GetMapping("/jpql/disponibili")
    public List<ElettricistaDto> elettricistiDisponibiliJPQL() {
        return elettricistaService.elettricistiDisponibiliJPQL();
    }

    // 7Native query
    @GetMapping("/native/{nome}")
    public ElettricistaDto findByNomeNative(@PathVariable String nome) {
        return elettricistaService.findByNomeNative(nome);
    }

    // 8 Native disponibili
    @GetMapping("/native/disponibili")
    public List<ElettricistaDto> findDisponibiliNative() {
        return elettricistaService.findDisponibiliNative();
    }

    // 9 Cognome + disponibile
    @GetMapping("/cognome-disponibile/{cognome}")
    public List<ElettricistaDto> findByCognomeAndDisponibileTrue(@PathVariable String cognome) {
        return elettricistaService.findByCognomeAndDisponibileTrue(cognome);
    }

    // 10 - Specializzazione + non disponibile
    @GetMapping("/spec-non-disponibili/{spec}")
    public List<ElettricistaDto> findBySpecializzazioneAndDisponibileFalse(@PathVariable String spec) {
        return elettricistaService.findBySpecializzazioneAndDisponibileFalse(spec);
    }
}