package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Drone")
@CrossOrigin(origins = "http://localhost:4200")
public class DroneController extends AbstractController<DroneDto> {

    @Autowired
    private DroneService service;

    @PostMapping("/insert")
    public DroneDto insert(@RequestBody DroneDto dto) {
        return service.insert(dto);
    }

    @GetMapping("/findByModello")
    public DroneDto findByModello(@RequestParam("modello") String modello) {
        return service.findByModello(modello);
    }

    @GetMapping("/trovaTramiteIniziale")
    public List<DroneDto> trovaTramiteIniziale(@RequestParam("find") Character i) {
        return service.trovaTramiteIniziale(i);
    }
}