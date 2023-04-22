package pl.sda.OrangeJavaPL2Spring.restapi;

import org.springframework.web.bind.annotation.*;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.entity.BreadRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class BreadController {
    BreadRepository repository;

    public BreadController(BreadRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/breads")
    public  List<Bread> getAllBreads(){
        return repository.getAllBreads();
    }

    @GetMapping("/bread/{id}")
    public Bread getBreadByID(@PathVariable int id){
        return repository.getBreadByID(id).orElse(null);
    }

    @GetMapping("/bread_by_price/{price}")
    public List<Bread> getBreadsByPrice(@PathVariable double price){
        Optional<List<Bread>> breadByPrice = repository.getBreadsByPrice(price);
        return breadByPrice.orElse(null);
    }

    @PostMapping("/breads")
    public void createBread(@RequestBody Bread bread){
        repository.addBread(bread);
    }

    @DeleteMapping("/breads/{id}")
    public void deleteBread(@PathVariable int id){
        Optional<Bread> breadToDelete = repository.findBreadById(id);
        breadToDelete.ifPresent(bread -> repository.deleteBread(bread));
    }

}
