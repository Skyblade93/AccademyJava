package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.ParcelDto;
import it.corso.AccademiJava.Model.Parcel;
import it.corso.AccademiJava.Service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Parcel")
@CrossOrigin(origins = "http://localhost:4200")
public class ParcelController extends AbstractController<ParcelDto>
{
    @Autowired
    private ParcelService parcelService;

    @GetMapping("/FindByWeight")
    public ParcelDto FindByWeight(@RequestParam("weight")Double weight) {return parcelService.findByWeight(weight);}

    @GetMapping("/FindByHeight")
    public ParcelDto FindByHeight(@RequestParam("height")Integer height)
    {
        return parcelService.findByHeight(height);
    }

    @GetMapping("/FindByLength")
    public ParcelDto FindByLength(@RequestParam("length")Integer length) { return parcelService.findByLength(length); }

    @GetMapping("/FindByWitdth")
    public ParcelDto FindByWidth(@RequestParam("width")Integer width){return parcelService.findByWidth(width);}

    @GetMapping("/weight-greater-than")
    public ParcelDto findByWeightGreaterThan(@RequestParam Double weight) {
        return parcelService.findByWeightGreaterThan(weight);
    }

    @GetMapping("/height-greater-than")
    public ParcelDto findByHeightGreaterThan(@RequestParam Integer height) {
        return parcelService.findByHeightGreaterThan(height);
    }

    @GetMapping("/length-greater-than")
    public ParcelDto findByLengthGreaterThan(@RequestParam Integer length) {
        return parcelService.findByLengthGreaterThan(length);
    }

    @GetMapping("/weight-and-height")
    public ParcelDto findByWeightAndHeight(@RequestParam Double weight,
                                           @RequestParam Integer height) {
        return parcelService.findByWeightAndHeight(weight, height);
    }

    @GetMapping("/width-and-length")
    public ParcelDto findByWidthAndLength(@RequestParam Double width,
                                          @RequestParam Integer length) {
        return parcelService.findByWidthAndLength(width, length);
    }

    @GetMapping("/width-greater-than")
    public ParcelDto findByWidthGreaterThan(@RequestParam Integer width) {
        return parcelService.findByWidhtGreaterThan(width);
    }

    @GetMapping("/FindByReceiverName")
    public ParcelDto findByReceiverName(@RequestParam String receiverName) {
        return parcelService.findByReceiverName(receiverName);
    }

    @GetMapping("/FindByReceiverSurname")
    public List<ParcelDto> findByReceiverSurname(@RequestParam String receiverSurname) {
        return parcelService.findByReceiverSurname(receiverSurname);
    }

    @GetMapping("/FindBySenderName")
    public ParcelDto findBySenderName(@RequestParam String SenderName) {
        return parcelService.findBySenderName(SenderName);
    }

    @GetMapping("/FindBySenderSurname")
    public ParcelDto findBySenderSurname(@RequestParam String SenderSurname) {
        return parcelService.findBySenderSurname(SenderSurname);
    }



}
