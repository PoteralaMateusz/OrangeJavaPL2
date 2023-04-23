package pl.sda.OrangeJavaPL2Spring.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.OrangeJavaPL2Spring.entity.Art;
import pl.sda.OrangeJavaPL2Spring.service.ArtService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArtController {
    private final ArtService service;

    @GetMapping("/arts")
    public ResponseEntity<List<Art>> findAll(){
        return service.findAllArts();
    }

    @PostMapping("/arts")
    public ResponseEntity<?> addArt(@RequestBody Art art){
        return service.addArt(art);
    }

    @DeleteMapping("/arts/{id}")
    public ResponseEntity<?> deleteArtByID(@PathVariable Long id){
        return service.deleteArtByID(id);
    }

    @PutMapping("/arts/{id}")
    public ResponseEntity<?> updateArtByID(@PathVariable Long id, @RequestBody Art art){
        return service.updateArtByID(id, art);
    }
}
