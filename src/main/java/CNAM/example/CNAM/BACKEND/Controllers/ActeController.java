package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Acte;
import CNAM.example.CNAM.BACKEND.Repositories.ActeRepository;

import java.util.List;


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

    
}
