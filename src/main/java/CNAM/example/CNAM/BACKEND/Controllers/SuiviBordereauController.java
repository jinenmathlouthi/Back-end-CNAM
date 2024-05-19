package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import CNAM.example.CNAM.BACKEND.Models.SuiviBordereau;
import CNAM.example.CNAM.BACKEND.Repositories.SuiviBordereauRepository;

import java.util.List;
// import java.util.Map;
// import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class SuiviBordereauController {

    @Autowired
    private SuiviBordereauRepository suiviBordereauRepository;

    @GetMapping("/suivibordreau")
    public List<SuiviBordereau> getAllSuiviBordreau() {
        return suiviBordereauRepository.findAll();
    }

    @GetMapping("/suivibordreau/{numeroBS}")
    public ResponseEntity<SuiviBordereau> getSuiviBordreauByNumeroBS(@PathVariable(value = "numeroBS") String numeroBS) {
        SuiviBordereau suiviBordereau = suiviBordereauRepository.findByNumeroBS(numeroBS);
        if (suiviBordereau == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(suiviBordereau);
    }

    @PostMapping("/suivibordreau")
    public ResponseEntity<?> createSuiviBordereau(@RequestBody SuiviBordereau suiviBordereau) {
        SuiviBordereau existingSuiviBordereau = suiviBordereauRepository.findByNumeroBS(suiviBordereau.getNumeroBS());
        if (existingSuiviBordereau != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Le suivi de bordereau existe déjà.");
        }

        SuiviBordereau createdSuiviBordereau = suiviBordereauRepository.save(suiviBordereau);
        return new ResponseEntity<>(createdSuiviBordereau, HttpStatus.CREATED);
    }

    @PutMapping("/suivibordreau/{numeroBS}")
    public ResponseEntity<SuiviBordereau> updateSuiviBordreau(@PathVariable(value = "numeroBS") String numeroBS,
                                           @RequestBody SuiviBordereau suiviBordereauDetails) {
        SuiviBordereau suiviBordereau = suiviBordereauRepository.findByNumeroBS(numeroBS);
        if (suiviBordereau == null) {
            return ResponseEntity.notFound().build();
        }

        suiviBordereau.setBEnvoi(suiviBordereauDetails.getBEnvoi());
        suiviBordereau.setMatriculeAdherents(suiviBordereauDetails.getMatriculeAdherents());
        suiviBordereau.setPrestataire(suiviBordereauDetails.getPrestataire());
        suiviBordereau.setNumeroBS(suiviBordereauDetails.getNumeroBS());
        suiviBordereau.setDateEmission(suiviBordereauDetails.getDateEmission());
        suiviBordereau.setPrestation(suiviBordereauDetails.getPrestation());
        suiviBordereau.setEtablissement(suiviBordereauDetails.getEtablissement());
        suiviBordereau.setMontant(suiviBordereauDetails.getMontant());
        suiviBordereau.setMontantFacture(suiviBordereauDetails.getMontantFacture());

        final SuiviBordereau updatedSuiviBordereau = suiviBordereauRepository.save(suiviBordereau);
        return ResponseEntity.ok(updatedSuiviBordereau);
    }

    // @DeleteMapping("/suivibordreau/{numeroBS}")
    // public ResponseEntity<Map<String, Boolean>> deleteSuiviBordreau(@PathVariable(value = "numeroBS") String numeroBS) {
    //     SuiviBordereau suiviBordereau = suiviBordereauRepository.findByNumeroBS(numeroBS);
    //     if (suiviBordereau == null) {
    //         return ResponseEntity.notFound().build();
    //     }

    //     suiviBordereauRepository.delete(suiviBordereau);
    //     Map<String, Boolean> response = new HashMap<>();
    //     response.put("deleted", Boolean.TRUE);
    //     return ResponseEntity.ok(response);
    // }
}
