package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.ParcelDto;
import it.corso.AccademiJava.Model.Parcel;
import it.corso.AccademiJava.Service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Parcel")
@CrossOrigin(origins = "http://localhost:4200")
public class ParcelController extends AbstractController<ParcelDto>
{
    @Autowired
    private ParcelService parcelService;

    @GetMapping("/FindByWeight")
    public ParcelDto FindByWeight(@RequestParam("weight")Double weight)
    {
     return parcelService.findByWeight(weight);
    }

    @GetMapping("/FindByHeight")
    public ParcelDto FindByHeight(@RequestParam("height")Integer height)
    {
        return parcelService.findByHeight(height);
    }



}
