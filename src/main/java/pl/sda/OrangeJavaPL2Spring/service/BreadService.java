package pl.sda.OrangeJavaPL2Spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.repository.BreadRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BreadService {
    private final BreadRepository repository;

    public ResponseEntity<List<Bread>> getAllBreads(){
        return ResponseEntity.ok(repository.getAllBreads());
    }

    public ResponseEntity<?> addBread(Bread bread){
        if(bread == null){
            return ResponseEntity
                    .status(404)
                    .build();
        }
        repository.addBread(bread);
        return ResponseEntity
                .status(201)
                .build();
    }

    public ResponseEntity<Bread> getBreadByID(int id){
        Optional<Bread> bread = repository.getBreadByID(id);
        return bread.isPresent() ? ResponseEntity.ok(bread.get()) : ResponseEntity.status(404).build();
    }

    public ResponseEntity<List<Bread>> getBreadsByPrice(double price){
        Optional<List<Bread>> breads = repository.getBreadsByPrice(price);
        return breads.isPresent() ? ResponseEntity.ok(breads.get()) : ResponseEntity.status(404).build();
    }

    public ResponseEntity<?> deleteBread(int id){
        Optional<Bread> breadToDelete = repository.getBreadByID(id);
        breadToDelete.ifPresent(repository::deleteBread);

        return ResponseEntity
                .status(202)
                .build();

    }
}
