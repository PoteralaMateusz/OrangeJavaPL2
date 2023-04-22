package pl.sda.OrangeJavaPL2Spring.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.OrangeJavaPL2Spring.entity.Address;
import pl.sda.OrangeJavaPL2Spring.entity.AddressRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {
    private final AddressRepository repository;

    @GetMapping("/addresses")
    public List<Address> getAllAddresses(){
        return repository.getAllAddresses();
    }

    @PostMapping("/address")
    public void createAddress(@RequestBody Address address){
        repository.createAddress(address);
    }
}
