package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.FichierSortie;
import CNAM.example.CNAM.BACKEND.Repositories.FichierSortieRepository;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class FichierSortieController {

    @Autowired
    private FichierSortieRepository fichierSortieRepository;

    @GetMapping("/fichiersorties")
    public List<FichierSortie> getAllFichierSorties() {
        return fichierSortieRepository.findAll();
    }

    @GetMapping("/fichiersorties/{id}")
    public ResponseEntity<FichierSortie> getFichierSortieById(@PathVariable(value = "id") Integer fichierSortieId) {
        Optional<FichierSortie> fichierSortie = fichierSortieRepository.findById(fichierSortieId);
        return fichierSortie.map(value -> ResponseEntity.ok().body(value))
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/fichiersorties")
    public ResponseEntity<FichierSortie> createFichierSortie(@RequestBody FichierSortie fichierSortie) {
        FichierSortie createdFichierSortie = fichierSortieRepository.save(fichierSortie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFichierSortie);
    }

    @PutMapping("/fichiersorties/{id}")
    public ResponseEntity<FichierSortie> updateFichierSortie(@PathVariable(value = "id") Integer fichierSortieId,
                                           @RequestBody FichierSortie fichierSortieDetails) {
        Optional<FichierSortie> fichierSortie = fichierSortieRepository.findById(fichierSortieId);
        if (fichierSortie.isPresent()) {
            FichierSortie existingFichierSortie = fichierSortie.get();
            existingFichierSortie.setCode(fichierSortieDetails.getCode());
            existingFichierSortie.setDateSoin(fichierSortieDetails.getDateSoin());
            existingFichierSortie.setRegimeRemboursement(fichierSortieDetails.getRegimeRemboursement());
            existingFichierSortie.setTotalDepense(fichierSortieDetails.getTotalDepense());
            existingFichierSortie.setActif(fichierSortieDetails.isActif());

            FichierSortie updatedFichierSortie = fichierSortieRepository.save(existingFichierSortie);
            return ResponseEntity.ok(updatedFichierSortie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/fichiersorties/{id}")
    public ResponseEntity<?> deleteFichierSortie(@PathVariable(value = "id") Integer fichierSortieId) {
        Optional<FichierSortie> fichierSortie = fichierSortieRepository.findById(fichierSortieId);
        if (fichierSortie.isPresent()) {
            fichierSortieRepository.delete(fichierSortie.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
