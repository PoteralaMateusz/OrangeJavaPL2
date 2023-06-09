package pl.sda.OrangeJavaPL2Spring.restapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.service.BreadService;

import java.util.List;

@RestController
public class BreadController {
    private final BreadService service;

    public BreadController(BreadService service) {
        this.service = service;
    }

    @GetMapping("/breads")
    public  ResponseEntity<List<Bread>> getAllBreads(){
        return service.getAllBreads();
    }

    @GetMapping("/breads/{id}")
    public ResponseEntity<Bread> getBreadByID(@PathVariable int id){
        return service.getBreadByID(id);
    }

    @GetMapping("/breads/price/{price}")
    public ResponseEntity<List<Bread>> getBreadsByPrice(@PathVariable double price){
        return service.getBreadsByPrice(price);
    }

    @GetMapping("/breads/breads/bread_type/{breadType}")
    public ResponseEntity<List<Bread>> getBreadsByBreadType(@PathVariable String breadType){
        return service.getBreadsByBreadType(breadType);
    }

    @PostMapping("/breads")
    public ResponseEntity<?> createBread(@RequestBody Bread bread){
        return service.addBread(bread);
    }

    @DeleteMapping("/breads/{id}")
    public ResponseEntity<?> deleteBreadByID(@PathVariable int id){
        return service.deleteBreadByID(id);
    }

    @PutMapping("/breads/{id}")
    public ResponseEntity<?> updateBread(@PathVariable int id,@RequestBody Bread toUpdate){
        return service.updateBread(id, toUpdate);
    }

    @PutMapping("/breads/name/{id}")
    public ResponseEntity<?> updateBreadName(@PathVariable int id,@RequestBody Bread toUpdate){
        return service.updateBreadName(id, toUpdate.getName());
    }

}
