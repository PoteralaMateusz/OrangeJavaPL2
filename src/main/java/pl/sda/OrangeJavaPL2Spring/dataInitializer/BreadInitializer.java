package pl.sda.OrangeJavaPL2Spring.dataInitializer;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.OrangeJavaPL2Spring.entity.BreadType;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.repository.BreadRepository;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class BreadInitializer {
    private final BreadRepository breadRepository;

    // wykonuje się gdy powstaje aplikacja
    @PostConstruct
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
}
