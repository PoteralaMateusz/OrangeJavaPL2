package pl.sda.OrangeJavaPL2Spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.OrangeJavaPL2Spring.entity.BreadType;
import pl.sda.OrangeJavaPL2Spring.entity.Bread;
import pl.sda.OrangeJavaPL2Spring.exceptions.BreadNotFoundException;
import pl.sda.OrangeJavaPL2Spring.repository.BreadRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BreadService {
    private final BreadRepository repository;

    public ResponseEntity<List<Bread>> getAllBreads() {
        return ResponseEntity.ok(repository.getAllBreads());
    }

    public ResponseEntity<Bread> getBreadByID(int id) {

        return ResponseEntity
                .status(200)
                .body(repository.getBreadByID(id).orElseThrow(() -> {
                    log.info("Cant get bread with " + id + ". This ID dont exist");
                    return new BreadNotFoundException("Bread not found");

                }));
    }

    public ResponseEntity<List<Bread>> getBreadsByPrice(double price) {
        Optional<List<Bread>> breads = repository.getBreadsByPrice(price);
        if (breads.map(List::size).orElse(0) == 0) {
            log.info("Breads with price: " + price + " dont exist");
            return ResponseEntity.status(404).build();
        }
        log.info("Showing breads with price: " + price + " .");
        return ResponseEntity.ok(breads.get());
    }

    public ResponseEntity<List<Bread>> getBreadsByBreadType(String type) {
        BreadType breadType;
        try {
            breadType = BreadType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            log.info("Getting BreadType dont exist");
            return ResponseEntity
                    .status(404)
                    .build();
        }
        log.info("Showing bread by breadType: " + type);
        return ResponseEntity
                .status(200).
                body(repository.findBreadsByBreadType(breadType));

    }

    public ResponseEntity<?> addBread(Bread bread) {
        if (bread == null) {
            log.info("Cant add empty bread.");
            return ResponseEntity
                    .status(404)
                    .build();
        }
        repository.addBread(bread);
        log.info("Adding bread: " + bread + " to db.");
        return ResponseEntity
                .status(201)
                .build();
    }

    public ResponseEntity<?> deleteBreadByID(int id) {
        Optional<Bread> breadToDelete = repository.getBreadByID(id);

        if (breadToDelete.isEmpty()) {
            log.info("Cant delete bread with id: " + id + " dont exist.");
            return ResponseEntity
                    .status(404)
                    .build();
        }

        breadToDelete.ifPresent(repository::deleteBread);
        log.info("Delete successful bread with id: " + id);
        return ResponseEntity
                .status(204)
                .build();
    }

    public ResponseEntity<?> updateBread(int id, Bread toUpdate) {
        Optional<Bread> isExist = repository.getBreadByID(id);
        if (isExist.isEmpty()) {
            log.info("Cant update bread with id: " + id + " dont exist.");
            return ResponseEntity
                    .status(404)
                    .build();
        }
        toUpdate.setId(id);
        repository.update(toUpdate);
        log.info("Update successful bread with id: " + id);
        return ResponseEntity
                .status(202)
                .build();
    }

    public ResponseEntity<?> updateBreadName(int id, String name) {
        Optional<Bread> isExist = repository.getBreadByID(id);
        if (isExist.isEmpty()) {
            log.info("Cant update bread with id: " + id + " dont exist.");
            return ResponseEntity
                    .status(404)
                    .build();
        }
        repository.updateBreadName(id, name);
        log.info("Update successful bread with id: " + id);
        return ResponseEntity
                .status(202)
                .build();
    }
}
