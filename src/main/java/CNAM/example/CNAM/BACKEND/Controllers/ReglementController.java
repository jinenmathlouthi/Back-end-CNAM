package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Reglement;
import CNAM.example.CNAM.BACKEND.Repositories.ReglementRepository;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ReglementController {

    @Autowired
    private ReglementRepository reglementRepository;

    @GetMapping("/reglements")
    public ResponseEntity<List<Reglement>> getAllReglements() {
        List<Reglement> reglements = reglementRepository.findAll();
        return ResponseEntity.ok().body(reglements);
    }

    @GetMapping("/reglements/{id}")
    public ResponseEntity<Reglement> getReglementById(@PathVariable Integer id) {
        Reglement reglement = reglementRepository.findById(id).orElse(null);
        if (reglement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(reglement);
    }

    @PostMapping("/reglements")
    public ResponseEntity<Reglement> addReglement(@RequestBody Reglement reglement) {
        Reglement createdReglement = reglementRepository.save(reglement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReglement);
    }

    @PutMapping("/reglements/{id}")
    public ResponseEntity<Reglement> updateReglement(@PathVariable Integer id, @RequestBody Reglement reglementDetails) {
        Reglement reglement = reglementRepository.findById(id).orElse(null);
        if (reglement == null) {
            return ResponseEntity.notFound().build();
        }

        reglement.setCode(reglementDetails.getCode());
        reglement.setEtablissementCode(reglementDetails.getEtablissementCode());
        reglement.setModeReglement(reglementDetails.getModeReglement());
        reglement.setDateReglement(reglementDetails.getDateReglement());
        reglement.setNumCheque(reglementDetails.getNumCheque());
        reglement.setMontant(reglementDetails.getMontant());
        reglement.setReste(reglementDetails.getReste());
        reglement.setModeReglement(reglementDetails.getModeReglement());

        final Reglement updatedReglement = reglementRepository.save(reglement);
        return ResponseEntity.ok(updatedReglement);
    }

    @DeleteMapping("/reglements/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteReglement(@PathVariable Integer id) {
        Reglement reglement = reglementRepository.findById(id).orElse(null);
        if (reglement == null) {
            return ResponseEntity.notFound().build();
        }

        reglementRepository.delete(reglement);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
