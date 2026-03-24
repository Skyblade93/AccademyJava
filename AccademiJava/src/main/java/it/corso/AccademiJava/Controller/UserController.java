package it.corso.AccademiJava.Controller;


import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("User")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<UserDto> {

    @Autowired
    private UserService service;

    @GetMapping("/FindByNome")
    public UserDto FindByNome(@RequestParam("nome") String nome) {
        return service.FindByNome(nome);
    }


}
