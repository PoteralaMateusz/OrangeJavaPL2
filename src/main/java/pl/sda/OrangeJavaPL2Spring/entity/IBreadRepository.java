package pl.sda.OrangeJavaPL2Spring.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IBreadRepository extends JpaRepository<Bread,Integer> {

    Optional<List<Bread>> getBreadsByPrice(double price);
}
