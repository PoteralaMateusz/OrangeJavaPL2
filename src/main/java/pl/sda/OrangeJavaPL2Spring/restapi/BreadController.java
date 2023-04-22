package pl.sda.OrangeJavaPL2Spring.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.repository.BreadRepository;
import pl.sda.OrangeJavaPL2Spring.service.BreadService;

import java.util.List;
import java.util.Optional;

@RestController
public class BreadController {
    private final BreadService service;

    public BreadController(BreadService service) {
        this.service = service;
    }

    @GetMapping("/breads")
    public  List<Bread> getAllBreads(){
        return service.getAllBreads();
    }

    @GetMapping("/bread/{id}")
    public Bread getBreadByID(@PathVariable int id){
        return service.getBreadByID(id).orElse(null);
    }

    @GetMapping("/bread_by_price/{price}")
    public List<Bread> getBreadsByPrice(@PathVariable double price){
        Optional<List<Bread>> breadByPrice = service.getBreadsByPrice(price);
        return breadByPrice.orElse(null);
    }

    @PostMapping("/breads")
    public ResponseEntity createBread(@RequestBody Bread bread){
        return service.addBread(bread);
    }

    @DeleteMapping("/breads/{id}")
    public ResponseEntity deleteBread(@PathVariable int id){
        return service.deleteBread(id);
    }

}
