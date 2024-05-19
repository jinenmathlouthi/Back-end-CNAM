package CNAM.example.CNAM.BACKEND.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import CNAM.example.CNAM.BACKEND.Models.Pharmacie;
import CNAM.example.CNAM.BACKEND.Repositories.PharmacieRepository;
        
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PharmacieController {

    @Autowired
    private PharmacieRepository pharmacieRepository;

    @GetMapping("/pharmacies")
    public List<Pharmacie> getAllPharmacies() {
        return pharmacieRepository.findAll();
    }

    @GetMapping("/pharmacies/{code}")
    public ResponseEntity<Pharmacie> getPharmacieByCode(@PathVariable Long code) {
        Pharmacie pharmacie = pharmacieRepository.findByCode(code);
        if (pharmacie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pharmacie);
    }

    @PostMapping("/pharmacies")
    public ResponseEntity<Pharmacie> createPharmacie(@RequestBody Pharmacie pharmacie) {
        Pharmacie createdPharmacie = pharmacieRepository.save(pharmacie);
        return new ResponseEntity<>(createdPharmacie, HttpStatus.CREATED);
    }

    @PutMapping("/pharmacies/{code}")
    public ResponseEntity<Pharmacie> updatePharmacie(@PathVariable Long code,
                                                     @RequestBody Pharmacie pharmacieDetails) {
        Pharmacie pharmacie = pharmacieRepository.findByCode(code);
        if (pharmacie == null) {
            return ResponseEntity.notFound().build();
        }

        pharmacie.setLibelle(pharmacieDetails.getLibelle());
        pharmacie.setConventionne(pharmacieDetails.getConventionne());
        pharmacie.setType(pharmacieDetails.getType());
        pharmacie.setCle(pharmacieDetails.getCle());
        pharmacie.setDateAdhesion(pharmacieDetails.getDateAdhesion());
        pharmacie.setAdresseLocale(pharmacieDetails.getAdresseLocale());
        pharmacie.setActif(pharmacieDetails.getActif());
        pharmacie.setPrestationsCode(pharmacieDetails.getPrestationsCode());

        final Pharmacie updatedPharmacie = pharmacieRepository.save(pharmacie);
        return ResponseEntity.ok(updatedPharmacie);
    }

    @DeleteMapping("/pharmacies/{code}")
    public ResponseEntity<Map<String, Boolean>> deletePharmacie(@PathVariable Long code) {
        Pharmacie pharmacie = pharmacieRepository.findByCode(code);
        if (pharmacie == null) {
            return ResponseEntity.notFound().build();
        }

        pharmacieRepository.delete(pharmacie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
