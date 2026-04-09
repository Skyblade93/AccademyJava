package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.ContactDto;
import it.corso.AccademiJava.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Contact")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController extends AbstractController<ContactDto> {

    @Autowired
    private ContactService service;

    // 🔹 INSERT
    @PostMapping("/insert")
    public ContactDto insert(@RequestBody ContactDto dto) {
        return service.insert(dto);
    }

    // 🔹 GET ALL
    @GetMapping("/getAll")
    public Iterable<ContactDto> getAll() {
        return service.getAll();
    }

    // 🔹 GET BY ID
    @GetMapping("/read")
    public ContactDto read(@RequestParam("id") Integer id) {
        return service.read(id);
    }

    // 🔹 UPDATE
    @PutMapping("/update")
    public ContactDto update(@RequestBody ContactDto dto) {
        return service.update(dto);
    }

    // 🔹 DELETE
    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Integer id) {
        service.delete(id);
    }

    // 🔹 CERCA PER EMAIL
    @GetMapping("/findByEmail")
    public ContactDto findByEmail(@RequestParam("email") String email) {
        return service.findByEmailDto(email);
    }

    // 🔹 CERCA PER NOME
    @GetMapping("/findByNome")
    public List<ContactDto> findByNome(@RequestParam("nome") String nome) {
        return service.findByNomeDto(nome);
    }
}