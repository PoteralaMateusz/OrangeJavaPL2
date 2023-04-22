package pl.sda.OrangeJavaPL2Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;


import java.util.List;
import java.util.Optional;

public interface IBreadRepository extends JpaRepository<Bread,Integer> {

    Optional<List<Bread>> getBreadsByPrice(double price);
}
