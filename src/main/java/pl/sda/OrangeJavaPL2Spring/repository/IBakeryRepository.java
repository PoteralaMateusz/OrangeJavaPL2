package pl.sda.OrangeJavaPL2Spring.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.OrangeJavaPL2Spring.entity.Bakery;

public interface IBakeryRepository extends JpaRepository<Bakery,Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO BAKERIES_BREAD_LIST  (BAKERY_ID, BREAD_LIST_ID) VALUES (:bakeryId ,:breadId)" ,nativeQuery = true)
    void addBreadToBakery(@Param("bakeryId") Long bakeryId, @Param("breadId") Long breadId);
}
