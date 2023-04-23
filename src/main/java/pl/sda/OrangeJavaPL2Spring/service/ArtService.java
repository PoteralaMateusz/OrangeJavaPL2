package pl.sda.OrangeJavaPL2Spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.OrangeJavaPL2Spring.entity.Art;
import pl.sda.OrangeJavaPL2Spring.repository.ArtRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtService {
    private final ArtRepository repository;

    public ResponseEntity<List<Art>> findAllArts(){

        return ResponseEntity
                .status(200)
                .body(repository.findAllArts());
    }

    public ResponseEntity addArt(Art toCreate){
        if(toCreate == null){
            return ResponseEntity
                    .status(404)
                    .build();
        }
        repository.addArt(toCreate);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity<?> deleteArtByID(Long id){
        Optional<Art> toDelete = repository.findArtByID(id);
        if (toDelete.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        repository.deleteArtByID(id);
        return ResponseEntity.status(200).build();
    }

    public ResponseEntity<?> updateArtByID(Long id,Art toUpdate){
        Optional<Art> isExist = repository.findArtByID(id);
        if (isExist.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        toUpdate.setId(id);
        repository.updateArtByID(toUpdate);
        return ResponseEntity.status(200).build();

    }
}
