package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Affilie;
import CNAM.example.CNAM.BACKEND.Repositories.AffilieRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AffilieController {

    @Autowired
    private AffilieRepository affilieRepository;

    @GetMapping("/affilies")
    public List<Affilie> getAllAffilies() {
        return affilieRepository.findAll();
    }

    @GetMapping("/affilies/numAdherent/{numAdherent}")
    public ResponseEntity<List<Affilie>> getAffilieByNumAdherent(@PathVariable(value = "numAdherent") Integer numAdherent) {
        List<Affilie> affilie = affilieRepository.findByAdherentMatricule(numAdherent);
        if (affilie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(affilie);
    }

    @PostMapping("/affilies")
    public ResponseEntity<Affilie> createAffilie(@RequestBody Affilie affilie) {
        Affilie createdAffilie = affilieRepository.save(affilie);
        return new ResponseEntity<>(createdAffilie, HttpStatus.CREATED);
    }

    @PutMapping("/affilies/{id}")
    public ResponseEntity<Affilie> updateAffilie(@PathVariable(value = "id") Integer affilieId,
                                           @RequestBody Affilie affilieDetails) {
        Affilie affilie = affilieRepository.findByCode(affilieId);
        if (affilie == null) {
            return ResponseEntity.notFound().build();
        }

        // Update affilie properties with affilieDetails
        affilie.setCode(affilieDetails.getCode());
        affilie.setNom(affilieDetails.getNom());
        affilie.setPrenom(affilieDetails.getPrenom());
        affilie.setDatenaissance(affilieDetails.getDatenaissance());
        affilie.setLienParente(affilieDetails.getLienParente());
        affilie.setRang(affilieDetails.getRang());
        affilie.setIdentifiantCNSSConjoint(affilieDetails.getIdentifiantCNSSConjoint());
        affilie.setFiliereConjoint(affilieDetails.getFiliereConjoint());
        affilie.setPecCnamConjoint(affilieDetails.getPecCnamConjoint());
        affilie.setSexe(affilieDetails.getSexe());
        affilie.setAdherentMatricule(affilieDetails.getAdherentMatricule());
        affilie.setACharge(affilieDetails.getACharge());
        affilie.setAEtudiant(affilieDetails.getAEtudiant());
        affilie.setAEndicape(affilieDetails.getAEndicape());
        affilie.setAPrimaire(affilieDetails.getAPrimaire());
        affilie.setASecondaire(affilieDetails.getASecondaire());
        affilie.setActif(affilieDetails.getActif());
        affilie.setCaisseAffiliation(affilieDetails.getCaisseAffiliation());
        affilie.setSoldeAssurance(affilieDetails.getSoldeAssurance());
        affilie.setAncienSoldeAssurance(affilieDetails.getAncienSoldeAssurance());
        affilie.setPlafonneAssurance(affilieDetails.getPlafonneAssurance());
        affilie.setAncienSoldeCNAM(affilieDetails.getAncienSoldeCNAM());
        affilie.setApci(affilieDetails.getApci());
        affilie.setMaladieCode(affilieDetails.getMaladieCode());

        final Affilie updatedAffilie = affilieRepository.save(affilie);
        return ResponseEntity.ok(updatedAffilie);
    }

    @DeleteMapping("/affilies/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAffilie(@PathVariable(value = "id") Integer affilieId) {
        Affilie affilie = affilieRepository.findByCode(affilieId);
        if (affilie == null) {
            return ResponseEntity.notFound().build();
        }

        affilieRepository.delete(affilie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
