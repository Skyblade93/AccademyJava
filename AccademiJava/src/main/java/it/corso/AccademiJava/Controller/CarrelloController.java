package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Service.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CarrelloDto findByQuantita(@RequestParam("quantita") int  quantita) {
        return service.findByQuantita(quantita);
    }

    @GetMapping("/findByPrezzoTotale")
    public CarrelloDto findByPrezzoTotale(@RequestParam("prezzoTotale") int  prezzoTotale) {
        return service.findByQuantita(prezzoTotale);
    }

}
