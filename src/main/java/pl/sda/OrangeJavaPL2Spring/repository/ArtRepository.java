package pl.sda.OrangeJavaPL2Spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sda.OrangeJavaPL2Spring.entity.Art;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ArtRepository {
    private final IArtRepository repository;

    public List<Art> findAllArts(){
        return repository.findAll();
    }

    public Optional<Art> findArtByID(long id){
        return repository.findById(id);
    }

    public void addArt(Art toCreate){
        repository.save(toCreate);
    }

    public void deleteArtByID(Long id){
        repository.deleteById(id);
    }

    public void updateArtByID(Art art){
        repository.save(art);
    }
}
