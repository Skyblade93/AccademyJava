package it.corso.AccademiJava.Controller;


import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("User")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<UserDto> {

    @Autowired
    private UserService service;

    @GetMapping("/findByNome")
    public UserDto FindByNome(@RequestParam("nome") String nome) {
        return service.findByNome(nome);
    }

    @PostMapping("/insert")
    public UserDto insert (@RequestBody UserDto dto) {
        service.insert(dto);
        return dto;
    }

    @GetMapping("/trovaTramiteiniziale")
    public List<UserDto> trovaTramiteiniziale(@RequestParam("find") Character i){
        return service.trovaTramiteiniziale(i);
    }


    @GetMapping("/urldb")
    public String getUrlDb(){
        return service.getDatabaseUrl();
    }

}
