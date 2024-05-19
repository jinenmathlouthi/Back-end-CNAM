package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Prestation;
import CNAM.example.CNAM.BACKEND.Repositories.PrestationRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PrestationController {

    @Autowired
    private PrestationRepository prestationRepository;

    @GetMapping("/prestations")
    public List<Prestation> getAllPrestations() {
        return prestationRepository.findAll();
    }

    @GetMapping("/prestations/{id}")
    public ResponseEntity<Prestation> getPrestationById(@PathVariable(value = "id") Long prestationId) {
        Prestation prestation = prestationRepository.findById(prestationId).orElse(null);
        if (prestation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(prestation);
    }
    

    @PostMapping("/prestations")
    public ResponseEntity<Prestation> createPrestation(@RequestBody Prestation prestation) {
        Prestation createdPrestation = prestationRepository.save(prestation);
        return new ResponseEntity<>(createdPrestation, HttpStatus.CREATED);
    }

    @PutMapping("/prestations/{id}")
    public ResponseEntity<Prestation> updatePrestation(@PathVariable(value = "id") Long prestationId,
                                                       @RequestBody Prestation prestationDetails) {
        Prestation prestation = prestationRepository.findById(prestationId).orElse(null);
        if (prestation == null) {
            return ResponseEntity.notFound().build();
        }

        prestation.setCode(prestationDetails.getCode());
        prestation.setLibelle(prestationDetails.getLibelle());
        prestation.setUnite(prestationDetails.getUnite());
        prestation.setPlafond(prestationDetails.getPlafond());
        prestation.setMontant(prestationDetails.getMontant());
        prestation.setPourcentage(prestationDetails.getPourcentage());
        prestation.setRubrique(prestationDetails.getRubrique());
        prestation.setFormule(prestationDetails.getFormule());
        prestation.setRetraite(prestationDetails.getRetraite());
        prestation.setActif(prestationDetails.getActif());

        final Prestation updatedPrestation = prestationRepository.save(prestation);
        return ResponseEntity.ok(updatedPrestation);
    }

    @DeleteMapping("/prestations/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePrestation(@PathVariable(value = "id") Long prestationId) {
        Prestation prestation = prestationRepository.findById(prestationId).orElse(null);
        if (prestation == null) {
            return ResponseEntity.notFound().build();
        }

        prestationRepository.delete(prestation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
