package it.corso.AccademiJava.Controller;

import it.corso.AccademiJava.DTO.ProductDto;
import it.corso.AccademiJava.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController extends AbstractController<ProductDto> {

    @Autowired
    private ProductService service;

    // ------------------ FIND BY NAME ------------------
    @GetMapping("/findByName")
    public ProductDto findByName(@RequestParam("name") String name) {
        return service.findByName(name);
    }

    // ------------------ INSERT ------------------
    @PostMapping("/insert")
    public ProductDto insert(@RequestBody ProductDto dto) {
        service.insert(dto);
        return dto;
    }


    // ------------------ FIND BY PRICE > ------------------
    @GetMapping("/findByPriceGreaterThan")
    public List<ProductDto> findByPriceGreaterThan(@RequestParam("price") Double price) {
        return service.findByPriceGreaterThan(price);
    }

    // ------------------ FIND BY QUANTITY < ------------------
    @GetMapping("/findByQuantityLessThan")
    public List<ProductDto> findByQuantityLessThan(@RequestParam("quantity") Integer quantity) {
        return service.findByQuantityLessThan(quantity);
    }

}