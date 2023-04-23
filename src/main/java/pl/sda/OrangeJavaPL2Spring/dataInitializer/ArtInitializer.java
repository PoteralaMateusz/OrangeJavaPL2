package pl.sda.OrangeJavaPL2Spring.dataInitializer;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.OrangeJavaPL2Spring.entity.Art;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.repository.BreadRepository;
import pl.sda.OrangeJavaPL2Spring.service.ArtService;

@Component
@RequiredArgsConstructor
public class ArtInitializer {
    private final ArtService service;

    @PostConstruct
    public void initBreads(){
        Art art1 = new Art("Portret",250);
        Art art2 = new Art("Pejzaż",500);

        service.addArt(art1);
        service.addArt(art2);

    }
}
