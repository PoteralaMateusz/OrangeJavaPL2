package pl.sda.OrangeJavaPL2Spring.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.OrangeJavaPL2Spring.entity.Bakery;
import pl.sda.OrangeJavaPL2Spring.exceptions.BakeryNotFoundException;
import pl.sda.OrangeJavaPL2Spring.repository.BakeryRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BakeryController {
    private final BakeryRepository repository;

    @GetMapping("/bakery")
    public ResponseEntity<List<Bakery>> getAllBakery(){
        return ResponseEntity
                .status(200)
                .body(repository.getAllBakeries());
    }
    @GetMapping("/bakery/{id}")
    public ResponseEntity<Bakery> getBakeryById(@PathVariable Long id){
        return ResponseEntity.status(200)
                .body(repository.getBakeryByID(id).orElseThrow(() -> new BakeryNotFoundException("Bakery not found")));
    }
}
