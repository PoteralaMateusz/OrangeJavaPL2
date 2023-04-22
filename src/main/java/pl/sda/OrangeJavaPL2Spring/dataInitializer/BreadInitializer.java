package pl.sda.OrangeJavaPL2Spring.dataInitializer;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.repository.BreadRepository;

@Component
@RequiredArgsConstructor
public class BreadInitializer {
    private final BreadRepository breadRepository;

    // wykonuje się gdy powstaje aplikacja
    @PostConstruct
    public void initBreads(){
        Bread bagietka = new Bread("Bagietka",3.5);
        Bread bread1 = new Bread("Chleb działdowski",3.5);
        Bread bread2 = new Bread("Chleb wieloziarnisty",4.59);
        Bread grahamka = new Bread("Bułka grahamka",1);

        breadRepository.addBread(bagietka);
        breadRepository.addBread(bread1);
        breadRepository.addBread(grahamka);
        breadRepository.addBread(bread2);
    }
}
