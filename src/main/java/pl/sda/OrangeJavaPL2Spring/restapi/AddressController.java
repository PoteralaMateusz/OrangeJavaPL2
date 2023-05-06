package pl.sda.OrangeJavaPL2Spring.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.OrangeJavaPL2Spring.entity.Address;
import pl.sda.OrangeJavaPL2Spring.exceptions.AddressNotFoundException;
import pl.sda.OrangeJavaPL2Spring.repository.AddressRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {
    private final AddressRepository repository;

    @GetMapping("/addresses")
    public List<Address> getAllAddresses(){
        return repository.getAllAddresses();
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddressByID(@PathVariable int id){
        return ResponseEntity
                .status(200)
                .body(repository.getAddressByID(id).orElseThrow(() -> new AddressNotFoundException("Address not found")));
    }

    @PostMapping("/address")
    public void createAddress(@RequestBody Address address){
        repository.createAddress(address);
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddress(@PathVariable int id){
        repository.deleteAddressByID(id);
    }

    @PutMapping("/address/{id}")
    public void updateAddress(@PathVariable int id, @RequestBody Address address){
        repository.updateAddress(id,address);
    }
}
