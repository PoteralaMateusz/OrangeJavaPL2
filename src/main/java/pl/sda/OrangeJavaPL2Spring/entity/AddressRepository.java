package pl.sda.OrangeJavaPL2Spring.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AddressRepository {

    private final IAddressRepository repository;

    public List<Address> getAllAddresses(){
        return repository.findAll();
    }

    public Optional<Address> getAddressByID(int id){
        return repository.findById(id);
    }

    public void createAddress(Address address){
        repository.save(address);
    }

}