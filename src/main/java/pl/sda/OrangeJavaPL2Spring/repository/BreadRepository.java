package pl.sda.OrangeJavaPL2Spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BreadRepository {
    private final IBreadRepository repository;

    public List<Bread> getAllBreads(){
        return repository.findAll();
    }

    public Optional<Bread> getBreadByID(int id){
        return repository.findById(id);
    }

    public Optional<List<Bread>> getBreadsByPrice(double price){
        return repository.getBreadsByPrice(price);
    }

    public void addBread(Bread bread){
        repository.save(bread);
    }

    public Optional<Bread> findBreadById(int id){
        return repository.findById(id);
    }

    public void deleteBread(Bread bread){
        repository.delete(bread);
    }
}