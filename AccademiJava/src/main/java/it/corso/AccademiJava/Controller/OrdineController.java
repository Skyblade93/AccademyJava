package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Service.OrdineService;
import it.corso.AccademiJava.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Ordine")
@CrossOrigin(origins = "http://localhost:8080")
public class OrdineController {

    @Autowired
    private OrdineService ordine;

    @GetMapping("/FindByNome")
    public UserDto FindByNome(@RequestParam("nome") String nome) {
        return service.FindByNome(nome);
    }


}
