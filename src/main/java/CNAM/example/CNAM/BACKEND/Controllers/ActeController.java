package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Acte;
import CNAM.example.CNAM.BACKEND.Repositories.ActeRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ActeController {

    @Autowired
    private ActeRepository acteRepository;

    @GetMapping("/actes")
    public List<Acte> getAllActes() {
        return acteRepository.findAll();
    }

    @GetMapping("/actes/{id}")
    public ResponseEntity<Acte> getActeById(@PathVariable(value = "id") String acteId) {
        Acte acte = acteRepository.findByCode(acteId);
        return ResponseEntity.ok().body(acte);
    }

    @PostMapping("/actes")
    public ResponseEntity<Acte> createActe(@RequestBody Acte acte) {
        Acte createdActe = acteRepository.save(acte);
        return new ResponseEntity<>(createdActe, HttpStatus.CREATED);
    }

    @PutMapping("/actes/{id}")
    public ResponseEntity<Acte> updateActe(@PathVariable(value = "id") String acteId,
                                           @RequestBody Acte acteDetails) {
        Acte acte = acteRepository.findByCode(acteId);
        if (acte == null) {
            return ResponseEntity.notFound().build();
        }

        acte.setCode(acteDetails.getCode());
        acte.setLettre(acteDetails.getLettre());
        acte.setDesignation(acteDetails.getDesignation());
        acte.setCotation(acteDetails.getCotation());
        acte.setPrixunite(acteDetails.getPrixunite());
        acte.setActif(acteDetails.getActif()); // Ajout de l'activation

        final Acte updatedActe = acteRepository.save(acte);
        return ResponseEntity.ok(updatedActe);
    }

    @DeleteMapping("/actes/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteActe(@PathVariable(value = "id") String acteId) {
        Acte acte = acteRepository.findByCode(acteId);
        if (acte == null) {
            return ResponseEntity.notFound().build();
        }

        acteRepository.delete(acte);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
