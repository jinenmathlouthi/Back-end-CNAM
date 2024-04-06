package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.EtablissementMedecin;
import CNAM.example.CNAM.BACKEND.Repositories.EtablissementMedecinRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

    @PutMapping("/etablissements-medecin/{code}")
    public ResponseEntity<EtablissementMedecin> updateEtablissementMedecin(@PathVariable Long code, @RequestBody EtablissementMedecin etablissementMedecinDetails) {
        EtablissementMedecin etablissementMedecin = etablissementMedecinRepository.findByCode(code);
        if (etablissementMedecin == null) {
            return ResponseEntity.notFound().build();
        }

        // Mise à jour des détails de l'établissement
        etablissementMedecin.setLibelle(etablissementMedecinDetails.getLibelle());
        etablissementMedecin.setDateAdhesion(etablissementMedecinDetails.getDateAdhesion());
        etablissementMedecin.setAdresseLocale(etablissementMedecinDetails.getAdresseLocale());
        etablissementMedecin.setConventionne(etablissementMedecinDetails.getConventionne());
        etablissementMedecin.setActif(etablissementMedecinDetails.getActif());
        // Mettre à jour d'autres champs si nécessaire

        final EtablissementMedecin updatedEtablissementMedecin = etablissementMedecinRepository.save(etablissementMedecin);
        return ResponseEntity.ok(updatedEtablissementMedecin);
    }

    @DeleteMapping("/etablissements-medecin/{code}")
    public ResponseEntity<Map<String, Boolean>> deleteEtablissementMedecin(@PathVariable Long code) {
        EtablissementMedecin etablissementMedecin = etablissementMedecinRepository.findByCode(code);
        if (etablissementMedecin == null) {
            return ResponseEntity.notFound().build();
        }

        etablissementMedecinRepository.delete(etablissementMedecin);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
