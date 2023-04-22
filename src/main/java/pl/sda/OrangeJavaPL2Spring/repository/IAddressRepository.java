package pl.sda.OrangeJavaPL2Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.OrangeJavaPL2Spring.entity.Address;

public interface IAddressRepository extends JpaRepository<Address,Integer> {
}
