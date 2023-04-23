package pl.sda.OrangeJavaPL2Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.OrangeJavaPL2Spring.entity.BreadType;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;


import java.util.List;
import java.util.Optional;

public interface IBreadRepository extends JpaRepository<Bread,Integer> {

    Optional<List<Bread>> findBreadsByPrice(double price);
    Optional<Bread> findBreadByName(String name);

    List<Bread> findBreadsByBreadType(BreadType breadType);

}
