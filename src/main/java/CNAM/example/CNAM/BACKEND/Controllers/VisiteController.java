package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Visite;
import CNAM.example.CNAM.BACKEND.Repositories.VisiteRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class VisiteController {

    @Autowired
    private VisiteRepository visiteRepository;

    @GetMapping("/visites")
    public List<Visite> getAllVisites() {
        return visiteRepository.findAll();
    }

    @GetMapping("/visites/{code}")
    public ResponseEntity<Visite> getVisiteByCode(@PathVariable(value = "code") String visiteCode) {
        Visite visite = visiteRepository.findByCode(visiteCode);
        if (visite == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(visite);
    }

    @PostMapping("/visites")
    public ResponseEntity<Visite> createVisite(@RequestBody Visite visite) {
        Visite createdVisite = visiteRepository.save(visite);
        return new ResponseEntity<>(createdVisite, HttpStatus.CREATED);
    }

    @PutMapping("/visites/{code}")
    public ResponseEntity<Visite> updateVisite(@PathVariable(value = "code") String visiteCode,
                                                 @RequestBody Visite visiteDetails) {
        Visite visite = visiteRepository.findByCode(visiteCode);
        if (visite == null) {
            return ResponseEntity.notFound().build();
        }

        visite.setCode(visiteDetails.getCode());
        visite.setLibelle(visiteDetails.getLibelle());
        visite.setPrix(visiteDetails.getPrix());
        visite.setCategorie(visiteDetails.getCategorie());
        visite.setTaux(visiteDetails.getTaux());
        visite.setActif(visiteDetails.getActif());

        final Visite updatedVisite = visiteRepository.save(visite);
        return ResponseEntity.ok(updatedVisite);
    }

    @DeleteMapping("/visites/{code}")
    public ResponseEntity<Map<String, Boolean>> deleteVisite(@PathVariable(value = "code") String visiteCode) {
        Visite visite = visiteRepository.findByCode(visiteCode);
        if (visite == null) {
            return ResponseEntity.notFound().build();
        }

        visiteRepository.delete(visite);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
