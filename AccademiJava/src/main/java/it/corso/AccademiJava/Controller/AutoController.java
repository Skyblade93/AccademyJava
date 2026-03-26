package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.AutoDto;
import it.corso.AccademiJava.Service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Auto")
@CrossOrigin(origins = "http://localhost:4200")
public class AutoController extends AbstractController<AutoDto> {

    @Autowired
    private AutoService autoService;


    // Trova per targa (JPQL)
    @GetMapping("/findByTarga")
    public AutoDto findByTarga(@RequestParam("targa") String targa) {
        return autoService.findByTarga(targa);
    }

    // Trova per marca (Native)
    @GetMapping("/findByMarca")
    public AutoDto findByMarca(@RequestParam("marca") String marca) {
        return autoService.findByMarca(marca);
    }

    // Trova per modello
    @GetMapping("/findByModello")
    public AutoDto findByModello(@RequestParam String modello) {
        return autoService.findByModello(modello);
    }

    // Trova per marca e modello
    @GetMapping("/findByMarcaAndModello")
    public AutoDto findByMarcaAndModello(@RequestParam("marca") String marca,
                                        @RequestParam("modello") String modello) {
        return autoService.findByMarcaAndModello(marca, modello);
    }

    // Trova modello contenente stringa
    @GetMapping("/findByModelloContaining")
    public AutoDto findByModelloContaining(@RequestParam("modello") String modello) {
        return autoService.findByModelloContaining(modello);
    }

    // Trova marca che inizia con
    @GetMapping("/findByMarcaStarting")
    public AutoDto findByMarcaStartingWith(@RequestParam("marca") String marca) {
        return autoService.findByMarcaStartingWith(marca);
    }

    // Trova marca che finisce con
    @GetMapping("/findByMarcaEndingWith")
    public AutoDto findByMarcaEndingWith(@RequestParam("marca") String marca) {
        return autoService.findByMarcaEndingWith(marca);
    }
}
