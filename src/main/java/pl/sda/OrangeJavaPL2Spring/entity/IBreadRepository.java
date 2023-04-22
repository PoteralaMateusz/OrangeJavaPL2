package pl.sda.OrangeJavaPL2Spring.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface IBreadRepository extends JpaRepository<Bread,Integer> {

    Optional<Bread> getBreadByPrice(double price);
}
