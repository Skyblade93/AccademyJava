package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.DipendenteDto;
import it.corso.AccademiJava.Service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Dipendente")
@CrossOrigin(origins="http://localhost:4200")
public class DipendenteController extends AbstractController<DipendenteDto> {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping("/findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono")
    public DipendenteDto findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono(
            @RequestParam("nomeDipendente") String nomeDipendente,
            @RequestParam("cognomeDipendente") String cognomeDipendente,
            @RequestParam("numeroTelefono") Integer numeroTelefono) {
        return dipendenteService.findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono(nomeDipendente, cognomeDipendente, numeroTelefono);
    }

    @GetMapping("/findByNomeDipendenteAndCognomeDipendente")
    public DipendenteDto findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono(
            @RequestParam("nomeDipendente") String nomeDipendente,
            @RequestParam("cognomeDipendente") String cognomeDipendente) {
        return dipendenteService.findByNomeAndCognome(nomeDipendente, cognomeDipendente);
    }

    @GetMapping("/findByEta")
    public List<DipendenteDto> findByEta(@RequestParam("eta") Integer eta) {
        return dipendenteService.findByEta(eta);
    }

    @GetMapping("/findByEtaGreaterThan")
    public List<DipendenteDto> findByEtaGreaterThan(@RequestParam("eta") Integer eta) {
        return dipendenteService.findByEtaGreaterThan(eta);
    }

    @GetMapping("/findByEmail")
    public DipendenteDto findByEmail(@RequestParam("email") String email) {
        return dipendenteService.findByEmail(email);
    }

}
