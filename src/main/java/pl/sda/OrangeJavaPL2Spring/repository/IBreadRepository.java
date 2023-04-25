package pl.sda.OrangeJavaPL2Spring.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.OrangeJavaPL2Spring.entity.BreadType;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;


import java.util.List;
import java.util.Optional;

public interface IBreadRepository extends JpaRepository<Bread,Integer> {

    Optional<List<Bread>> findBreadsByPrice(double price);
    Optional<Bread> findBreadByName(String name);

    List<Bread> findBreadsByBreadType(BreadType breadType);

    @Modifying
    @Transactional
    @Query("UPDATE Bread b SET b.name = :name WHERE b.id = :id")
    void updateBreadName(@Param("id") int id,@Param("name") String name);

}
