package pl.sda.OrangeJavaPL2Spring.dataInitializer;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.OrangeJavaPL2Spring.entity.Address;
import pl.sda.OrangeJavaPL2Spring.entity.AddressRepository;

@Component
@RequiredArgsConstructor
public class AddressInitializer {
    private final AddressRepository repository;

    @PostConstruct
    public void initAddresses() {
        Address address1 = new Address("Warszawska",145,"24-300","Poland");
        Address address2 = new Address("Jana Pawła 2",14,"24-300","Poland");
        Address address3 = new Address("Główna",69,"24-300","Poland");

        repository.createAddress(address1);
        repository.createAddress(address2);
        repository.createAddress(address3);
    }

}
