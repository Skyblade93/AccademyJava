package it.corso.AccademiJava.Controller;


import it.corso.AccademiJava.DTO.AziendaDto;
import it.corso.AccademiJava.Service.AziendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Azienda")
@CrossOrigin(origins = "http://localhost:4200")
public class AziendaController {

    @Autowired
    private AziendaService service;

    @GetMapping("/CercaPerNome")
    public AziendaDto CercaPerNome(@RequestParam("nome") String nomeAzienda){
        return service.cercaPerNome(nomeAzienda);
    }

    @GetMapping("/CercaPerDescrizione")
    public AziendaDto cercaPerDescrizione(@RequestParam("descrizione") String descrizioneAzienda) {
        return service.trovaPerDescrizioneNative(descrizioneAzienda);
    }
}
