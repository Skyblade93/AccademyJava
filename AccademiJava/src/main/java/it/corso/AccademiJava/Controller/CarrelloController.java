package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Service.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Carrello")
@CrossOrigin(origins = "http://localhost:4200")
public class CarrelloController extends AbstractController<CarrelloDto> {

    @Autowired
    private CarrelloService service;

    @GetMapping("/findById")
    public CarrelloDto findById(@RequestParam("id") int id) {
        return service.findById(id);
    }

    @GetMapping("/findByQuantita")
    public List<CarrelloDto> findByQuantita(@RequestParam("quantita") int  quantita) {
        return service.cercaPerQuantita(quantita);
    }

    @GetMapping("/cercaPerPrezzoTotale")
    public List<CarrelloDto> cercaPrezzoTotale(@RequestParam("prezzoTotale") double  prezzoTotale) {
        return service.cercaPrezzoTotale(prezzoTotale);
    }

    @GetMapping("/cercaPerQuantitaAndPrezzoTotale")
    public List<CarrelloDto> cercaPerQuantitaAndPrezzoTotale(@RequestParam("prezzoTotale") double  prezzoTotale, @RequestParam("quantita") int quantita) {
        return service.findByQuantitaAndPrezzoTotale(quantita, prezzoTotale);
    }

    @GetMapping("/cercaPerIdAndPrezzoTotale")
    public CarrelloDto cercaPerIdAndPrezzoTotale(@RequestParam("id") int id, @RequestParam("prezzoTotale") double prezzoTotale) {
        return service.findByIdAndPrezzoTotale(id, prezzoTotale);
    }

    @GetMapping("/cercaPerIdAndQuantita")
    public CarrelloDto cercaPerIdAndQuantita(@RequestParam("id") int id, @RequestParam("quantita") int quantita) {
        return service.findByIdAndPrezzoTotale(id, quantita);
    }

    @GetMapping("/trovaPrezzoMaggioreDi10")
    public List<Boolean> trovaPrezzoMaggioreDi10(@RequestParam("prezzoTotale") double prezzoTotale) {
        return service.trovaPrezzoMaggioreDi10(prezzoTotale);
    }
}
