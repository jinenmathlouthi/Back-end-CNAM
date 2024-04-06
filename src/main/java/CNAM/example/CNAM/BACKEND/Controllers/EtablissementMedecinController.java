package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.EtablissementMedecin;
import CNAM.example.CNAM.BACKEND.Repositories.EtablissementMedecinRepository;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EtablissementMedecinController {

    @Autowired
    private EtablissementMedecinRepository etablissementMedecinRepository;

    @GetMapping("/etablissements-medecin")
    public List<EtablissementMedecin> getAllEtablissementsMedecin() {
        return etablissementMedecinRepository.findAll();
    }

    @GetMapping("/etablissements-medecin/{code}")
    public ResponseEntity<EtablissementMedecin> getEtablissementMedecinByCode(@PathVariable Long code) {
        EtablissementMedecin etablissementMedecin = etablissementMedecinRepository.findByCode(code);
        if (etablissementMedecin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(etablissementMedecin);
    }

    @PostMapping("/etablissements-medecin")
    public ResponseEntity<EtablissementMedecin> createEtablissementMedecin(@RequestBody EtablissementMedecin etablissementMedecin) {
        EtablissementMedecin createdEtablissementMedecin = etablissementMedecinRepository.save(etablissementMedecin);
        return new ResponseEntity<>(createdEtablissementMedecin, HttpStatus.CREATED);
    }

    
}
