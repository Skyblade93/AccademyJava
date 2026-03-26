package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.DipendenteDto;
import it.corso.AccademiJava.Service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Dipendente")
@CrossOrigin(origins="http://localhost:8081")
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
    public DipendenteDto findByNomeDipendenteAndCognomeDipendente(
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

    @GetMapping("/findByEmailAndEta")
    public DipendenteDto findByEmailAndEta(@RequestParam("email") String email,
                                           @RequestParam("eta") Integer eta) {
        return dipendenteService.findByEmailAndEta(email, eta);
    }

    @GetMapping("/findByNomeDipendenteAndEta")
    public DipendenteDto findByNomeDipendenteAndEta(@RequestParam("nomeDipendente") String nomeDipendente,
                                                    @RequestParam("eta") Integer eta) {
        return dipendenteService.findByNomeDipendenteAndEta(nomeDipendente, eta);
    }

    @GetMapping("/findByCognomeDipendente")
    public DipendenteDto findByCognomeDipendente(@RequestParam("cognomeDipendente") String cognomeDipendente) {
        return dipendenteService.findByCognomeDipendente(cognomeDipendente);
    }

    @GetMapping("/findByEmailAndNumeroTelefono")
    public DipendenteDto findByEmailAndNumeroTelefono(@RequestParam("email") String email,
                                                      @RequestParam("numeroTelefono") Integer numeroTelefono) {
        return dipendenteService.findByEmailAndNumeroTelefono(email, numeroTelefono);
    }

    @GetMapping("/findByNomeDipendente")
    public DipendenteDto findByNomeDipendente(@RequestParam("nomeDipendente") String nomeDipendente) {
        return dipendenteService.findByNomeDipendente(nomeDipendente);
    }

}
