package pl.sda.OrangeJavaPL2Spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.entity.BreadType;

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
        return repository.findBreadsByPrice(price);
    }

    public void addBread(Bread bread){
        repository.save(bread);
    }


    public Optional<Bread> findBreadById(int id){
        return repository.findById(id);
    }

    public Optional<Bread> findBreadByName(String name){
        return repository.findBreadByName(name);
    }

    public List<Bread> findBreadsByBreadType(BreadType breadType){
        return repository.findBreadsByBreadType(breadType);
    }

    public void deleteBread(Bread bread){
        repository.delete(bread);
    }

    public void update(Bread toUpdate) {
        repository.save(toUpdate);
    }

    public void updateBreadName(int id, String name) {
        repository.updateBreadName(id,name);
    }
}
