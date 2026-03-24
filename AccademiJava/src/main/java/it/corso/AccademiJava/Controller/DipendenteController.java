package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.DipendenteDto;
import it.corso.AccademiJava.Service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Dipendente")
@CrossOrigin(origins="http://localhost:4200")
public class DipendenteController extends AbstractController<DipendenteDto> {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping("/read")
    public DipendenteDto read(@RequestParam("nomeDipendente") String nomeDipendete) {
        return dipendenteService.findByNome(nomeDipendete);
    }
}
