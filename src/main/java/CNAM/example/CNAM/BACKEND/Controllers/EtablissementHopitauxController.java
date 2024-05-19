package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.EtablissementHopitaux;
import CNAM.example.CNAM.BACKEND.Repositories.EtablissementHopitauxRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EtablissementHopitauxController {

    @Autowired
    private EtablissementHopitauxRepository etablissementHopitauxRepository;

    @GetMapping("/etablissements")
    public List<EtablissementHopitaux> getAllEtablissementsHopitaux() {
        return etablissementHopitauxRepository.findAll();
    }

    @GetMapping("/etablissements/{code}")
    public ResponseEntity<EtablissementHopitaux> getEtablissementHopitauxByCode(@PathVariable Long code) {
        EtablissementHopitaux etablissementHopitaux = etablissementHopitauxRepository.findByCode(code);
        if (etablissementHopitaux == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(etablissementHopitaux);
    }

    @PostMapping("/etablissements")
    public ResponseEntity<EtablissementHopitaux> createEtablissementHopitaux(@RequestBody EtablissementHopitaux etablissementHopitaux) {
        EtablissementHopitaux createdEtablissementHopitaux = etablissementHopitauxRepository.save(etablissementHopitaux);
        return new ResponseEntity<>(createdEtablissementHopitaux, HttpStatus.CREATED);
    }

    @PutMapping("/etablissements/{code}")
    public ResponseEntity<EtablissementHopitaux> updateEtablissementHopitaux(@PathVariable Long code,
                                                                             @RequestBody EtablissementHopitaux etablissementHopitauxDetails) {
        EtablissementHopitaux etablissementHopitaux = etablissementHopitauxRepository.findByCode(code);
        if (etablissementHopitaux == null) {
            return ResponseEntity.notFound().build();
        }

        etablissementHopitaux.setLibelle(etablissementHopitauxDetails.getLibelle());
        etablissementHopitaux.setDateAdhesion(etablissementHopitauxDetails.getDateAdhesion());
        etablissementHopitaux.setType(etablissementHopitauxDetails.getType());
        etablissementHopitaux.setCle(etablissementHopitauxDetails.getCle());
        etablissementHopitaux.setAdresseLocale(etablissementHopitauxDetails.getAdresseLocale());
        etablissementHopitaux.setConventionne(etablissementHopitauxDetails.getConventionne());
        etablissementHopitaux.setActif(etablissementHopitauxDetails.getActif());

        final EtablissementHopitaux updatedEtablissementHopitaux = etablissementHopitauxRepository.save(etablissementHopitaux);
        return ResponseEntity.ok(updatedEtablissementHopitaux);
    }

    @DeleteMapping("/etablissements/{code}")
    public ResponseEntity<Map<String, Boolean>> deleteEtablissementHopitaux(@PathVariable Long code) {
        EtablissementHopitaux etablissementHopitaux = etablissementHopitauxRepository.findByCode(code);
        if (etablissementHopitaux == null) {
            return ResponseEntity.notFound().build();
        }

        etablissementHopitauxRepository.delete(etablissementHopitaux);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
