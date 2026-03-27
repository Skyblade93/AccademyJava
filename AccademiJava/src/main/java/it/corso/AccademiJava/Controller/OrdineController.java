package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.OrdineDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Service.OrdineService;
import it.corso.AccademiJava.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Ordine")
@CrossOrigin(origins = "http://localhost:8080")
public class OrdineController extends AbstractController<OrdineDto>{

    @Autowired
    private OrdineService service;

    @GetMapping("/findById")
    public OrdineDto findById(@RequestParam("id") int id){
        return service.findById(id);
    }

    @GetMapping("/trovaConCostoUguale")
    public List<OrdineDto> trovaConCostoUguale(@RequestParam("costo") float costo_totale){
        return service.trovaConCostoUguale(costo_totale);
    }

    @GetMapping("/trovaConNumeroProdottiMaggiore")
    public List<OrdineDto> trovaConNumeroProdottiMaggiore(@RequestParam("num_prodotti") Integer num){
        return service.trovaConNumeroProdottiMaggiore(num);
    }

    @GetMapping("/trovaConIndirizzo")
    public List<OrdineDto> trovaConIndirizzo(@RequestParam("indirizzo") String indirizzo){
        return service.trovaConIndirizzo(indirizzo);
    }

    @GetMapping("/trovaConCostoMaggiore")
    public List<OrdineDto> trovaConCostoMaggiore(@RequestParam("costo") float costo){
        return service.trovaConCostoMaggiore(costo);
    }

    @GetMapping("/trovaConCostoMinore")
    public List<OrdineDto> trovaConCostoMinore(@RequestParam("costo") float costo){
        return service.trovaConCostoMinore(costo);
    }

    @GetMapping("/trovaPerUtente")
    public List<OrdineDto> trovaPerUtente(@RequestParam("utente") Integer id){
        return service.trovaPerUtente(id);
    }

    @GetMapping("/filtro")
    public List<OrdineDto> filtro(@RequestParam("numero") Integer num, @RequestParam("costo") float costo){
        return service.filtro(num,costo);
    }

    @GetMapping("/ordinaPerCostoDecrescente")
    public List<OrdineDto> ordinaPerCostoDecrescente(){
        return service.ordinaPerCostoDecrescente();
    }

    @GetMapping("/trovaTraDueCosti")
    public List<OrdineDto> trovaTraDueCosti(@RequestParam("min") float min, @RequestParam("max") float max){
        return service.trovaTraDueCosti(min,max);
    }
}
