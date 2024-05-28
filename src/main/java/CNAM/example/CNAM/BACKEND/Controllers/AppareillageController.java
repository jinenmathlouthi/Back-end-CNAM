package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Appareillage;
import CNAM.example.CNAM.BACKEND.Repositories.AppareillageRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AppareillageController {

    @Autowired
    private AppareillageRepository appareillageRepository;

    @GetMapping("/appareillages")
    public List<Appareillage> getAllAppareillages() {
        return appareillageRepository.findAll();
    }

    @GetMapping("/appareillages/{id}")
    public ResponseEntity<Appareillage> getAppareillageById(@PathVariable(value = "id") Integer appareillageId) {
        Appareillage appareillage = appareillageRepository.findByCode(appareillageId);
        if (appareillage == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(appareillage);
    }

    @PostMapping("/appareillages")
    public ResponseEntity<Appareillage> createAppareillage(@RequestBody Appareillage appareillage) {
        Appareillage createdAppareillage = appareillageRepository.save(appareillage);
        return new ResponseEntity<>(createdAppareillage, HttpStatus.CREATED);
    }

    @PutMapping("/appareillages/{id}")
    public ResponseEntity<Appareillage> updateAppareillage(@PathVariable(value = "id") Integer appareillageId,
                                                       @RequestBody Appareillage appareillageDetails) {
        Appareillage appareillage = appareillageRepository.findByCode(appareillageId);
        if (appareillage == null) {
            return ResponseEntity.notFound().build();
        }

        appareillage.setLibelle(appareillageDetails.getLibelle());
        appareillage.setPrix(appareillageDetails.getPrix());
        appareillage.setActif(appareillageDetails.isActif());

        final Appareillage updatedAppareillage = appareillageRepository.save(appareillage);
        return ResponseEntity.ok(updatedAppareillage);
    }

    @DeleteMapping("/appareillages/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppareillage(@PathVariable(value = "id") Integer appareillageId) {
        Appareillage appareillage = appareillageRepository.findByCode(appareillageId);
        if (appareillage == null) {
            return ResponseEntity.notFound().build();
        }

        appareillageRepository.delete(appareillage);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
