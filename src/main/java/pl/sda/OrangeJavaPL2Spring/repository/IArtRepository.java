package pl.sda.OrangeJavaPL2Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.OrangeJavaPL2Spring.entity.Art;

public interface IArtRepository extends JpaRepository<Art,Long> {
}
