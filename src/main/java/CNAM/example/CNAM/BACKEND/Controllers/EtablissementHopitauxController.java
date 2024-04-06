package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.EtablissementHopitaux;
import CNAM.example.CNAM.BACKEND.Repositories.EtablissementHopitauxRepository;

import java.util.List;
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

   
}
