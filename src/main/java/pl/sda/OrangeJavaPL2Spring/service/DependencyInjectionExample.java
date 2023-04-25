package pl.sda.OrangeJavaPL2Spring.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.OrangeJavaPL2Spring.repository.AddressRepository;

@Service// = @Component = @Repository = @Bean
public class DependencyInjectionExample {
//Dependency injection explanation
//    @Autowired // DI by field
//    AddressRepository addressRepository;
//
//    @Autowired // DI by constructor
//    public DependencyInjectionExample(AddressRepository addressRepository) {
//        this.addressRepository = addressRepository;
//    }
//
//    @Autowired // DI by constructor
//    public void setAddressRepository(AddressRepository addressRepository) {
//        this.addressRepository = addressRepository;
//    }
}
