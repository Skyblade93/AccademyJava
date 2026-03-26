package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.AziendaDto;
import it.corso.AccademiJava.Service.AziendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Azienda")
@CrossOrigin(origins = "http://localhost:4200")
public class AziendaController {

    @Autowired
    private AziendaService service;

    //Ricerca un'azienda esatta per nome
    @GetMapping("/findByNomeAzienda")
    public AziendaDto findByNomeAzienda(@RequestParam("nome") String nomeAzienda) {
        return service.findByNomeAzienda(nomeAzienda);
    }

    //Ricerca aziende il cui nome contiene una parola (ignore case)
    @GetMapping("/findByNomeAziendaContainingIgnoreCase")
    public List<AziendaDto> findByNomeAziendaContainingIgnoreCase(@RequestParam("parola")  String parola) {
        return service.findByNomeAziendaContainingIgnoreCase(parola);
    }


    //Ricerca aziende il cui campo descrizione contiene una parola (ignore case)
    @GetMapping("/findByDescrizioneAziendaContainingIgnoreCase")
    public List<AziendaDto> findByDescrizioneAziendaContainingIgnoreCase(@RequestParam("descrizione") String descrizioneAzienda) {
        return service.findByDescrizioneAziendaContainingIgnoreCase(descrizioneAzienda);
    }


    //Ricerca un'azienda tramite l'ID del titolare
    @GetMapping("/findByTitolare_Id")
    public AziendaDto findByTitolare_Id(@RequestParam("titolare") Integer titolare) {
        return service.findByTitolare_Id(titolare);
    }


    //Ricerca aziende il cui nome contiene una parola (case-sensitive)
    @GetMapping("/findByNomeAziendaContaining")
    public List<AziendaDto> findByNomeAziendaContaining(@RequestParam("parola") String parola) {
        return service.findByNomeAziendaContaining(parola);
    }

    //Cerca un'azienda esatta per nome (simile a findByNomeAzienda)
    @GetMapping("/CercaPerNome")
    public AziendaDto CercaPerNome(@RequestParam("nome") String nomeAzienda){
        return service.cercaPerNome(nomeAzienda);
    }

    //Cerca aziende per descrizione (lista)
    @GetMapping("/CercaPerDescrizione")
    public List<AziendaDto> cercaPerDescrizione(@RequestParam("descrizione") String descrizioneAzienda) {
        return service.cercaPerDescrizione(descrizioneAzienda);
    }


    //Trova aziende tramite query nativa per descrizione
    @GetMapping("/trovaPerDescrizioneNative")
    public List<AziendaDto> trovaPerDescrizioneNative(@RequestParam("descirizone") String descirizoneAzienda) {
        return service.trovaPerDescrizioneNative(descirizoneAzienda);
    }
}
