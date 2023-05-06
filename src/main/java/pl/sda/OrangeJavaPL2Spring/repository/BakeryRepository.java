package pl.sda.OrangeJavaPL2Spring.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.OrangeJavaPL2Spring.entity.Bakery;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BakeryRepository {
    private final IBakeryRepository repository;

    public List<Bakery> getAllBakeries(){
        return repository.findAll();
    }
    public Optional<Bakery> getBakeryByID(Long id){
        return repository.findById(id);
    }

    public void createBakery(Bakery toAdd){
        repository.save(toAdd);
    }

    public void addBreadToBakery(Long bakeryId, Long breadId){
        repository.addBreadToBakery(bakeryId,breadId);
    }


}
