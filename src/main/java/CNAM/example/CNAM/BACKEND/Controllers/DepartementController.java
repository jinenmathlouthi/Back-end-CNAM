package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Departement;
import CNAM.example.CNAM.BACKEND.Repositories.DepartementRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class DepartementController {

    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping("/departements")
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @GetMapping("/departements/{code}")
    public ResponseEntity<Departement> getDepartementByCode(@PathVariable(value = "code") long departementCode) {
        Departement departement = departementRepository.findByCode(departementCode);
        if (departement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(departement);
    }

    @PostMapping("/departements")
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
        Departement createdDepartement = departementRepository.save(departement);
        return new ResponseEntity<>(createdDepartement, HttpStatus.CREATED);
    }

    @PutMapping("/departements/{code}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable(value = "code") long departementCode,
                                           @RequestBody Departement departementDetails) {
        Departement departement = departementRepository.findByCode(departementCode);
        if (departement == null) {
            return ResponseEntity.notFound().build();
        }

        departement.setLibelle(departementDetails.getLibelle());
        departement.setActif(departementDetails.isActif());

        final Departement updatedDepartement = departementRepository.save(departement);
        return ResponseEntity.ok(updatedDepartement);
    }

    @DeleteMapping("/departements/{code}")
    public ResponseEntity<Map<String, Boolean>> deleteDepartement(@PathVariable(value = "code") long departementCode) {
        Departement departement = departementRepository.findByCode(departementCode);
        if (departement == null) {
            return ResponseEntity.notFound().build();
        }

        departementRepository.delete(departement);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
