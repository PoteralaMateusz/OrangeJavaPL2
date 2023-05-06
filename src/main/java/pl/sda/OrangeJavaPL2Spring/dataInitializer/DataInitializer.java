package pl.sda.OrangeJavaPL2Spring.dataInitializer;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.OrangeJavaPL2Spring.entity.*;
import pl.sda.OrangeJavaPL2Spring.repository.AddressRepository;
import pl.sda.OrangeJavaPL2Spring.repository.BakeryRepository;
import pl.sda.OrangeJavaPL2Spring.repository.BreadRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final BakeryRepository bakeryRepository;
    private final BreadRepository breadRepository;
    private final AddressRepository addressRepository;

    @PostConstruct
    public void init(){
        initAddresses();
        initBreads();
        initBakery();
    }

    public void initAddresses() {
        Address address1 = new Address("Warszawska",145,"24-300","Poland");
        Address address2 = new Address("Jana Pawła 2",14,"24-300","Poland");
        Address address3 = new Address("Główna",69,"24-300","Poland");

        addressRepository.createAddress(address1);
        addressRepository.createAddress(address2);
        addressRepository.createAddress(address3);
    }
    public void initBreads(){
        Bread bread = new Bread("Bułka", BreadType.WHEAT, BigDecimal.valueOf(3.5));
        Bread bread1 = new Bread("Chleb działdowski", BreadType.WHEAT,BigDecimal.valueOf(3.5));
        Bread bread2 = new Bread("Chleb wieloziarnisty", BreadType.MULTIGRAIN,BigDecimal.valueOf(4.59));
        Bread bread3 = new Bread("Drożdźówka", BreadType.SWEET,BigDecimal.valueOf(1));

        breadRepository.addBread(bread);
        breadRepository.addBread(bread1);
        breadRepository.addBread(bread3);
        breadRepository.addBread(bread2);
    }
    public void initBakery(){
        Bread bread = new Bread("Bułka serowa", BreadType.WHEAT, BigDecimal.valueOf(3.5));
        Bread bread1 = new Bread("Chleb warszawski", BreadType.WHEAT,BigDecimal.valueOf(3.5));
        List<Bread> breadsToAdd = Arrays.asList(bread,bread1);


        Address addressToAdd = new Address("Mickiewicza",14,"24-300","Poland");
        Owner owner = new Owner("Mateusz","Kowalski",44);


        Bakery bakeryToAdd = new Bakery(breadsToAdd,addressToAdd,owner);

        bakeryRepository.createBakery(bakeryToAdd);
        bakeryRepository.addBreadToBakery(1L,2L);
        bakeryRepository.addBreadToBakery(1L,1L);
        bakeryRepository.createBakery(bakeryToAdd);
    }
}
