package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Medicament;
import CNAM.example.CNAM.BACKEND.Repositories.MedicamentRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

    @PutMapping("/medicaments/{id}")
    public ResponseEntity<Medicament> updateMedicament(@PathVariable(value = "id") Long medicamentId,
                                                       @RequestBody Medicament medicamentDetails) {
        Medicament medicament = medicamentRepository.findByCode(medicamentId);
        if (medicament == null) {
            return ResponseEntity.notFound().build();
        }

        medicament.setCode(medicamentDetails.getCode());
        medicament.setLibelle(medicamentDetails.getLibelle());
        medicament.setPrix(medicamentDetails.getPrix());
        medicament.setPrixPrevisionnelCnam(medicamentDetails.getPrixPrevisionnelCnam());
        medicament.setCategorie(medicamentDetails.getCategorie());
        medicament.setConventionne(medicamentDetails.getConventionne());
        medicament.setActif(medicamentDetails.getActif());

        final Medicament updatedMedicament = medicamentRepository.save(medicament);
        return ResponseEntity.ok(updatedMedicament);
    }

    @DeleteMapping("/medicaments/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMedicament(@PathVariable(value = "id") Long medicamentId) {
        Medicament medicament = medicamentRepository.findByCode(medicamentId);
        if (medicament == null) {
            return ResponseEntity.notFound().build();
        }

        medicamentRepository.delete(medicament);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
