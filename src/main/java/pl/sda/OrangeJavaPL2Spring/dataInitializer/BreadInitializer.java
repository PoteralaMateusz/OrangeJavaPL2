package pl.sda.OrangeJavaPL2Spring.dataInitializer;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.entity.BreadRepository;

@Component
@RequiredArgsConstructor
public class BreadInitializer {
    private final BreadRepository breadRepository;

    // wykonuje się gdy powstaje aplikacja
    @PostConstruct
    public void initBreads(){
        Bread bagietka = new Bread(3,"Bagietka",3.5);
        Bread grahamka = new Bread(4,"Bułka grahamka",1);

        breadRepository.addBread(bagietka);
        breadRepository.addBread(grahamka);
    }
}
