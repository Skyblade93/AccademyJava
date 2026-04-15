package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.ElettricistaDto;
import it.corso.AccademiJava.Service.ElettricistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elettricisti")
public class ElettricistaController {

    @Autowired
    private ElettricistaService elettricistaService;

    // 1 Cerca elettricista per nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<ElettricistaDto> findByNome(@PathVariable String nome) {
        ElettricistaDto dto = elettricistaService.findByNome(nome);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    // 2 prende tutti gli elettricisti disponibili
    @GetMapping("/disponibili")
    public List<ElettricistaDto> findDisponibili() {
        return elettricistaService.findDisponibili();
    }

    //prende tutti gli elettricisti
    @GetMapping("/all")
    public List<ElettricistaDto> findAll() {
        return elettricistaService.findAll();
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
    public ResponseEntity<ElettricistaDto> cercaPerNomeJPQL(@PathVariable String nome) {
        ElettricistaDto dto = elettricistaService.cercaPerNomeJPQL(nome);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    // 6 Lista disponibili con JPQL
    @GetMapping("/jpql/disponibili")
    public List<ElettricistaDto> elettricistiDisponibiliJPQL() {
        return elettricistaService.elettricistiDisponibiliJPQL();
    }

    // 7 Native query
    @GetMapping("/native/{nome}")
    public ResponseEntity<ElettricistaDto> findByNomeNative(@PathVariable String nome) {
        ElettricistaDto dto = elettricistaService.findByNomeNative(nome);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    // 8 Native disponibili (senza pathvariable)
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