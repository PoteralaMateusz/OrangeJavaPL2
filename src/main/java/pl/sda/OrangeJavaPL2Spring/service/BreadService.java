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

    public List<Bread> getAllBreads(){
        return repository.getAllBreads();
    }

    public ResponseEntity addBread(Bread bread){
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

    public Optional<Bread> getBreadByID(int id){
        return repository.getBreadByID(id);
    }

    public Optional<List<Bread>> getBreadsByPrice(double price){
        return repository.getBreadsByPrice(price);
    }

    public ResponseEntity deleteBread(int id){
        Optional<Bread> breadToDelete = repository.getBreadByID(id);
        breadToDelete.ifPresent(repository::deleteBread);

        return ResponseEntity
                .status(202)
                .build();

    }
}
