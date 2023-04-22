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
    public  List<Bread> getBreads(){
        return repository.findAll();
    }

    @GetMapping("/bread_by_price/{price}")
    public Bread getBreadByPrice(@PathVariable double price){
        Optional<Bread> breadByPrice = repository.getBreadByPrice(price);
        return breadByPrice.orElse(null);
    }

    @PostMapping("/breads")
    public void createBread(@RequestBody Bread bread){
        repository.save(bread);
    }

    @DeleteMapping("/breads/{id}")
    public void deleteBread(@PathVariable int id){
        Optional<Bread> breadToDelete = repository.findById(id);
        breadToDelete.ifPresent(bread -> repository.delete(bread));
    }

}
