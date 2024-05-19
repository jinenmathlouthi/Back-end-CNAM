package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Maladie;
import CNAM.example.CNAM.BACKEND.Repositories.MaladieRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MaladieController {

    @Autowired
    private MaladieRepository maladieRepository;

    @GetMapping("/maladies")
    public List<Maladie> getAllMaladies() {
        return maladieRepository.findAll();
    }

    @GetMapping("/maladies/{code}")
    public ResponseEntity<Maladie> getMaladieByCode(@PathVariable(value = "code") Integer maladieCode) {
        Maladie maladie = maladieRepository.findByCode(maladieCode);
        if (maladie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(maladie);
    }

    @PostMapping("/maladies")
    public ResponseEntity<Maladie> createMaladie(@RequestBody Maladie maladie) {
        Maladie createdMaladie = maladieRepository.save(maladie);
        return new ResponseEntity<>(createdMaladie, HttpStatus.CREATED);
    }

    @PutMapping("/maladies/{code}")
    public ResponseEntity<Maladie> updateMaladie(@PathVariable(value = "code") Integer maladieCode,
                                                 @RequestBody Maladie maladieDetails) {
        Maladie maladie = maladieRepository.findByCode(maladieCode);
        if (maladie == null) {
            return ResponseEntity.notFound().build();
        }

        maladie.setCode(maladieDetails.getCode());
        maladie.setLibelle(maladieDetails.getLibelle());
        maladie.setActif(maladieDetails.getActif());

        final Maladie updatedMaladie = maladieRepository.save(maladie);
        return ResponseEntity.ok(updatedMaladie);
    }

    @DeleteMapping("/maladies/{code}")
    public ResponseEntity<Map<String, Boolean>> deleteMaladie(@PathVariable(value = "code") Integer maladieCode) {
        Maladie maladie = maladieRepository.findByCode(maladieCode);
        if (maladie == null) {
            return ResponseEntity.notFound().build();
        }

        maladieRepository.delete(maladie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
