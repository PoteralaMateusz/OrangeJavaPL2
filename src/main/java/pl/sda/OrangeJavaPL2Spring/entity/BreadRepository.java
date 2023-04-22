package pl.sda.OrangeJavaPL2Spring.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BreadRepository extends JpaRepository<Bread,Integer> {

    Optional<Bread> getBreadByPrice(double price);
}
