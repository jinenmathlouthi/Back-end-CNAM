package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Prestation;
import CNAM.example.CNAM.BACKEND.Repositories.PrestationRepository;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PrestationController {

    @Autowired
    private PrestationRepository prestationRepository;

    @GetMapping("/prestations")
    public List<Prestation> getAllPrestations() {
        return prestationRepository.findAll();
    }

    @GetMapping("/prestations/{id}")
    public ResponseEntity<Prestation> getPrestationById(@PathVariable(value = "id") Long prestationId) {
        Prestation prestation = prestationRepository.findById(prestationId).orElse(null);
        if (prestation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(prestation);
    }
    

    @PostMapping("/prestations")
    public ResponseEntity<Prestation> createPrestation(@RequestBody Prestation prestation) {
        Prestation createdPrestation = prestationRepository.save(prestation);
        return new ResponseEntity<>(createdPrestation, HttpStatus.CREATED);
    }

    
}
