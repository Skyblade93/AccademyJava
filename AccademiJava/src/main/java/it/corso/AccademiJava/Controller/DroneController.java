package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Drone")
@CrossOrigin(origins = "http://localhost:4200")
// RIMOSSO <DroneDto> dopo il nome della classe
public class DroneController extends AbstractController<DroneDto> {

    @Autowired
    private DroneService service;

    @PostMapping("/insert")
    // RIMOSSO <DroneDto> davanti al tipo di ritorno
    public DroneDto insert(@RequestBody DroneDto dto) {
        return (DroneDto) service.insert(dto);
    }

    /*
    @GetMapping("/findByModello")
    // RIMOSSO <DroneDto> davanti al tipo di ritorno
    public DroneDto findByModello(@RequestParam("modello") String modello) {
        return (DroneDto) service.findByModello(modello);
    }

    @GetMapping("/trovaTramiteIniziale")
    // RIMOSSO <DroneDto> davanti alla List
    public List<DroneDto> trovaTramiteIniziale(@RequestParam("find") Character i) {
        // Qui non serve il cast (DroneDto), il service restituisce già il tipo giusto
        return service.trovaTramiteIniziale(i);
    }

     */
}