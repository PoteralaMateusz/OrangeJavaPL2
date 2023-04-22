package pl.sda.OrangeJavaPL2Spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.OrangeJavaPL2Spring.entity.Address;

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

    public void deleteAddressByID(int id){
        Optional<Address> address = repository.findById(id);
        address.ifPresent(repository::delete);
    }

    public void updateAddress(int id, Address address){
        Optional<Address> toUpdate = repository.findById(id);
        if(toUpdate.isPresent()){
            address.setId(id);
            repository.save(address);
        }
    }

}
