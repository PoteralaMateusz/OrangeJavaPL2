package pl.sda.OrangeJavaPL2Spring.restapi;

import org.springframework.web.bind.annotation.*;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.entity.BreadRepository;

import java.util.List;

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

    @PostMapping("/breads")
    public void createBread(@RequestBody Bread bread){
        repository.save(bread);
    }

}
