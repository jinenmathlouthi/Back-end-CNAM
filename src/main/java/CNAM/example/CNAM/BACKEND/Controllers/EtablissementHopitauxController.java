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
    public List<EtablissementHopitaux> getAllEtablissements() {
        return etablissementHopitauxRepository.findAll();
    }

    @GetMapping("/etablissements/{code}")
    public ResponseEntity<EtablissementHopitaux> getEtablissementById(@PathVariable(value = "code") Long code) {
        EtablissementHopitaux etablissement = etablissementHopitauxRepository.findById(code).orElse(null);
        if (etablissement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(etablissement);
    }

    @PostMapping("/etablissements")
    public ResponseEntity<EtablissementHopitaux> createEtablissement(@RequestBody EtablissementHopitaux etablissement) {
        EtablissementHopitaux createdEtablissement = etablissementHopitauxRepository.save(etablissement);
        return new ResponseEntity<>(createdEtablissement, HttpStatus.CREATED);
    }

    @PutMapping("/etablissements/{code}")
    public ResponseEntity<EtablissementHopitaux> updateEtablissement(@PathVariable(value = "code") Long code,
                                                                     @RequestBody EtablissementHopitaux etablissementDetails) {
        EtablissementHopitaux etablissement = etablissementHopitauxRepository.findById(code).orElse(null);
        if (etablissement == null) {
            return ResponseEntity.notFound().build();
        }

        etablissement.setLibelle(etablissementDetails.getLibelle());
        etablissement.setDateAdhesion(etablissementDetails.getDateAdhesion());
        etablissement.setType(etablissementDetails.getType());
        etablissement.setCle(etablissementDetails.getCle());
        etablissement.setAdresseLocale(etablissementDetails.getAdresseLocale());
        etablissement.setConventionne(etablissementDetails.getConventionne());
        etablissement.setActif(etablissementDetails.getActif());

        final EtablissementHopitaux updatedEtablissement = etablissementHopitauxRepository.save(etablissement);
        return ResponseEntity.ok(updatedEtablissement);
    }

    @DeleteMapping("/etablissements/{code}")
    public ResponseEntity<Map<String, Boolean>> deleteEtablissement(@PathVariable(value = "code") Long code) {
        EtablissementHopitaux etablissement = etablissementHopitauxRepository.findById(code).orElse(null);
        if (etablissement == null) {
            return ResponseEntity.notFound().build();
        }

        etablissementHopitauxRepository.delete(etablissement);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
