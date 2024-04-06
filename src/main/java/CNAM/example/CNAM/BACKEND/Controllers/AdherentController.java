package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Adherent;
import CNAM.example.CNAM.BACKEND.Repositories.AdherentRepository;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AdherentController {

    @Autowired
    private AdherentRepository adherentRepository;

    @GetMapping("/adherents")
    public List<Adherent> getAllAdherents() {
        return adherentRepository.findAll();
    }

    @GetMapping("/adherents/{id}")
    public ResponseEntity<Adherent> getAdherentById(@PathVariable(value = "id") int matricule) {
        Adherent adherent = adherentRepository.findByMatricule(matricule);
        return ResponseEntity.ok().body(adherent);
    }

    @PostMapping("/adherents")
    public ResponseEntity<Adherent> createAdherent(@RequestBody Adherent adherent) {
        Adherent createdAdherent = adherentRepository.save(adherent);
        return new ResponseEntity<>(createdAdherent, HttpStatus.CREATED);
    }

   
}
