package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("Drone")
@CrossOrigin(origins = "http://localhost:4200") // Permette ad Angular di entrare
public class DroneController {

    @Autowired
    private DroneService service;

    @GetMapping("/getall")
    public List<DroneDto> getAll() {
        return (List<DroneDto>) service.getAll();
    }

    @PostMapping("/insert")
    public DroneDto insert(@RequestBody DroneDto dto) {
        return service.insert(dto);
    }

    @PutMapping("/update")
    public DroneDto update(@RequestBody DroneDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Integer id) {
        service.delete(id);
    }

    @GetMapping("/findByModello")
    public DroneDto findByModello(@RequestParam("modello") String modello) {
        return service.findByModello(modello);
    }
}