package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CNAM.example.CNAM.BACKEND.Models.Adherent;
import CNAM.example.CNAM.BACKEND.Repositories.AdherentRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

    @PutMapping("/adherents/{id}")
    public ResponseEntity<Adherent> updateAdherent(@PathVariable(value = "id") int matricule,
                                                   @RequestBody Adherent adherentDetails) {
        Adherent adherent = adherentRepository.findByMatricule(matricule);
        if (adherent == null) {
            return ResponseEntity.notFound().build();
        }

        adherent.setNom(adherentDetails.getNom());
        adherent.setPrenom(adherentDetails.getPrenom());
        adherent.setDatenaissance(adherentDetails.getDatenaissance());
        adherent.setDatenaissance(adherentDetails.getDatenaissance());
        adherent.setDateembauche(adherentDetails.getDateembauche());
        adherent.setSexe(adherentDetails.getSexe());
        adherent.setSituationfamiliale(adherentDetails.getSituationfamiliale());
        adherent.setCaisseaffiliation(adherentDetails.getCaisseaffiliation());
        adherent.setSoldecnam(adherentDetails.getSoldecnam());
        adherent.setPlafonne(adherentDetails.getPlafonne());
        adherent.setRetraite(adherentDetails.getRetraite());
        adherent.setPlafonneassurance(adherentDetails.getPlafonneassurance());
        adherent.setPersonnecharge(adherentDetails.getPersonnecharge());
        adherent.setApci(adherentDetails.getApci());
        adherent.setActif(adherentDetails.getActif());
        adherent.setSoldecnam(adherentDetails.getSoldecnam());
        adherent.setFiliere(adherentDetails.getFiliere());
        adherent.setAdresse_locale(adherentDetails.getAdresse_locale());
        adherent.setTerritoire(adherentDetails.getTerritoire());
        adherent.setNombreenfants(adherentDetails.getNombreenfants());
        adherent.setRib(adherentDetails.getRib());
        adherent.setSoldeassurance(adherentDetails.getSoldeassurance());
        adherent.setMedecin_code(adherentDetails.getMedecin_code());
        adherent.setAnciensoldeassurance(adherentDetails.getAnciensoldeassurance());
        adherent.setAnciensoldecnam(adherentDetails.getAnciensoldecnam());
        adherent.setCartecnss(adherentDetails.getCartecnss());
        adherent.setPhoto(adherentDetails.getPhoto());
        adherent.setStatut(adherentDetails.getStatut());
        adherent.setDatecin(adherentDetails.getDatecin());
        adherent.setNumadherent(adherentDetails.getNumadherent());
        adherent.setNationalite(adherentDetails.getNationalite());
        adherent.setMaladie_code(adherentDetails.getMaladie_code());
        adherent.setDepartement_code(adherentDetails.getDepartement_code());
        adherent.setQualification_code(adherentDetails.getQualification_code());
        adherent.setService_code(adherentDetails.getService_code());
        adherent.setEtablissement_code(adherentDetails.getEtablissement_code());

        final Adherent updatedAdherent = adherentRepository.save(adherent);
        return ResponseEntity.ok(updatedAdherent);
    }

    @DeleteMapping("/adherents/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAdherent(@PathVariable(value = "id") int matricule) {
        Adherent adherent = adherentRepository.findByMatricule(matricule);
        if (adherent == null) {
            return ResponseEntity.notFound().build();
        }

        adherentRepository.delete(adherent);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
