package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Medicament;
import CNAM.example.CNAM.BACKEND.Repositories.MedicamentRepository;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MedicamentController {

    @Autowired
    private MedicamentRepository medicamentRepository;

    @GetMapping("/medicaments")
    public List<Medicament> getAllMedicaments() {
        return medicamentRepository.findAll();
    }

    @GetMapping("/medicaments/{id}")
    public ResponseEntity<Medicament> getMedicamentById(@PathVariable(value = "id") Long medicamentId) {
        Medicament medicament = medicamentRepository.findByCode(medicamentId);
        return ResponseEntity.ok().body(medicament);
    }
    

    @PostMapping("/medicaments")
    public ResponseEntity<Medicament> createMedicament(@RequestBody Medicament medicament) {
        Medicament createdMedicament = medicamentRepository.save(medicament);
        return new ResponseEntity<>(createdMedicament, HttpStatus.CREATED);
    }

   
}
