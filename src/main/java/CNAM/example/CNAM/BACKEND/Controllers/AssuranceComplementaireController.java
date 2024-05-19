package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import CNAM.example.CNAM.BACKEND.Models.AssuranceComplementaire;
import CNAM.example.CNAM.BACKEND.Repositories.AssuranceComplementaireRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AssuranceComplementaireController {

    @Autowired
    private AssuranceComplementaireRepository assuranceComplementaireRepository;

    @GetMapping("/assurances-complementaires")
    public List<AssuranceComplementaire> getAllAssurancesComplementaires() {
        return assuranceComplementaireRepository.findAll();
    }

    @GetMapping("/assurances-complementaires/{code}")
    public ResponseEntity<AssuranceComplementaire> getAssuranceComplementaireByCode(@PathVariable(value = "code") int code) {
        AssuranceComplementaire assuranceComplementaire = assuranceComplementaireRepository.findByCode(code);
        if (assuranceComplementaire == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(assuranceComplementaire);
    }

    @PostMapping("/assurances-complementaires")
    public ResponseEntity<?> createAssuranceComplementaire(@RequestBody AssuranceComplementaire assuranceComplementaire) {
        AssuranceComplementaire existingAssuranceComplementaire = assuranceComplementaireRepository.findByCode(assuranceComplementaire.getCode());
        if (existingAssuranceComplementaire != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("L'assurance complémentaire existe déjà.");
        }

        AssuranceComplementaire createdAssuranceComplementaire = assuranceComplementaireRepository.save(assuranceComplementaire);
        return new ResponseEntity<>(createdAssuranceComplementaire, HttpStatus.CREATED);
    }

    @PutMapping("/assurances-complementaires/{code}")
    public ResponseEntity<AssuranceComplementaire> updateAssuranceComplementaire(@PathVariable(value = "code") int code,
                                           @RequestBody AssuranceComplementaire assuranceComplementaireDetails) {
        AssuranceComplementaire assuranceComplementaire = assuranceComplementaireRepository.findByCode(code);
        if (assuranceComplementaire == null) {
            return ResponseEntity.notFound().build();
        }

        assuranceComplementaire.setDateSoin(assuranceComplementaireDetails.getDateSoin());
        assuranceComplementaire.setTotalDepense(assuranceComplementaireDetails.getTotalDepense());
        assuranceComplementaire.setTotalRemboursement(assuranceComplementaireDetails.getTotalRemboursement());
        assuranceComplementaire.setMatriculeAdherents(assuranceComplementaireDetails.getMatriculeAdherents());

        final AssuranceComplementaire updatedAssuranceComplementaire = assuranceComplementaireRepository.save(assuranceComplementaire);
        return ResponseEntity.ok(updatedAssuranceComplementaire);
    }

    @DeleteMapping("/assurances-complementaires/{code}")
    public ResponseEntity<Map<String, Boolean>> deleteAssuranceComplementaire(@PathVariable(value = "code") int code) {
        AssuranceComplementaire assuranceComplementaire = assuranceComplementaireRepository.findByCode(code);
        if (assuranceComplementaire == null) {
            return ResponseEntity.notFound().build();
        }

        assuranceComplementaireRepository.delete(assuranceComplementaire);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
