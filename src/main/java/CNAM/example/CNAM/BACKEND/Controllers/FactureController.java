package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Facture;
import CNAM.example.CNAM.BACKEND.Repositories.FactureRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class FactureController {

    @Autowired
    private FactureRepository factureRepository;

    @GetMapping("/factures")
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @GetMapping("/factures/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable(value = "id") int code) {
        Facture facture = factureRepository.findByCode(code);
        if (facture == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(facture);
    }

    @PostMapping("/factures")
    public ResponseEntity<Facture> createFacture(@RequestBody Facture facture) {
        Facture createdFacture = factureRepository.save(facture);
        return new ResponseEntity<>(createdFacture, HttpStatus.CREATED);
    }

    @PutMapping("/factures/{id}")
    public ResponseEntity<Facture> updateFacture(@PathVariable(value = "id") int code,
                                                   @RequestBody Facture factureDetails) {
        Facture facture = factureRepository.findByCode(code);
        if (facture == null) {
            return ResponseEntity.notFound().build();
        }

        facture.setCodeFiliale(factureDetails.getCodeFiliale());
        facture.setDateEdition(factureDetails.getDateEdition());
        facture.setDateDebut(factureDetails.getDateDebut());
        facture.setDateFin(factureDetails.getDateFin());
        facture.setCloture(factureDetails.isCloture());
        facture.setMontant(factureDetails.getMontant());
        facture.setActif(factureDetails.isActif());
        facture.setMontantRemb(factureDetails.getMontantRemb());
        facture.setMontantDepense(factureDetails.getMontantDepense());
        facture.setApayer(factureDetails.getApayer());
        facture.setAregler(factureDetails.getAregler());
        facture.setReste(factureDetails.getReste());
        facture.setEtablissementCode(factureDetails.getEtablissementCode());
        facture.setReglementCode(factureDetails.getReglementCode());
        facture.setNumFacture(factureDetails.getNumFacture());
        facture.setReference(factureDetails.getReference());

        final Facture updatedFacture = factureRepository.save(facture);
        return ResponseEntity.ok(updatedFacture);
    }

    @DeleteMapping("/factures/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFacture(@PathVariable(value = "id") int code) {
        Facture facture = factureRepository.findByCode(code);
        if (facture == null) {
            return ResponseEntity.notFound().build();
        }

        factureRepository.delete(facture);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
