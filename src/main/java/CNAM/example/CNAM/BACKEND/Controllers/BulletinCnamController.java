package CNAM.example.CNAM.BACKEND.Controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import CNAM.example.CNAM.BACKEND.Models.BordereauCnam;
import CNAM.example.CNAM.BACKEND.Models.BulletinCnam;
import CNAM.example.CNAM.BACKEND.Repositories.BordereauCnamRepository;
import CNAM.example.CNAM.BACKEND.Repositories.BulletinCnamRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cnam")
public class BulletinCnamController {

    @Autowired
    private BulletinCnamRepository bulletinCnamRepository;
    @Autowired
    private BordereauCnamRepository bordereauCnamRepository;

    @GetMapping("/bulletins")
    public List<BulletinCnam> getAllBulletins() {
        return bulletinCnamRepository.findAll();
    }

    @GetMapping("/bulletins/{matriculeadherent}")
    public ResponseEntity<BulletinCnam> getBulletinById(@PathVariable(value = "matriculeadherent") Long matriculeadherent) {
        BulletinCnam bulletin = bulletinCnamRepository.findByMatriculeAdherent(matriculeadherent);
        if (bulletin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(bulletin);
    }

  @PostMapping("/bulletins")
public ResponseEntity<BulletinCnam> createBulletin(@RequestBody BulletinCnam bulletin) {
   
    Long bulletinSoinNum = generateUniqueBulletinNum();
    bulletin.setBulletinsoinnum(bulletinSoinNum);
  
    BulletinCnam createdBulletin = bulletinCnamRepository.save(bulletin);
    BordereauCnam bordereauCnam = new BordereauCnam();
    bordereauCnam.setMatricule_adherent(bulletin.getMatriculeAdherent());
    bordereauCnam.setBulletinsoinnum(bulletin.getBulletinsoinnum());
    bordereauCnam.setAdherent(bulletin.getNom() + " " + bulletin.getPrenom());
    bordereauCnam.setIdentifiantcnss(bulletin.getIdentifiantCnss());
    bordereauCnam.setAffilie(bulletin.getNom() + bulletin.getPrenomAffilie());
    bordereauCnam.setBulletinsoinnum(bulletin.getBulletinsoinnum());
    bordereauCnam.setDatesoin(bulletin.getDateSoin());
    bordereauCnam.setPrestationlibelle(bulletin.getObservation());
    bordereauCnam.setEtablissementlibelle(String.valueOf(bulletin.getPharmacie()));
    bordereauCnam.setRemboursement(bulletin.getTotalRembCNAM());
    bordereauCnam.setDepenses(bulletin.getTotalDepenses());
    bordereauCnamRepository.save(bordereauCnam);

    return ResponseEntity.status(HttpStatus.CREATED).body(createdBulletin);
}

    

    private Long generateUniqueBulletinNum() {
        Random random = new Random();
        return Math.abs(random.nextLong()); 
    }
    

    @PutMapping("/bulletins/{matriculeadherent}")
    public ResponseEntity<BulletinCnam> updateBulletin(@PathVariable(value = "matriculeadherent") Long matriculeadherent,
            @RequestBody BulletinCnam bulletinDetails) {
        BulletinCnam bulletin = bulletinCnamRepository.findByMatriculeAdherent(matriculeadherent);
        if (bulletin == null) {
            return ResponseEntity.notFound().build();
        }
    
        BulletinCnam savedBulletin = bulletinCnamRepository.save(bulletinDetails);
        return ResponseEntity.ok(savedBulletin);
    }
    

    @DeleteMapping("/bulletins/{matriculeadherent}")
    public ResponseEntity<?> deleteBulletin(@PathVariable(value = "matriculeadherent") Long matriculeadherent) {
        BulletinCnam bulletin = bulletinCnamRepository.findByMatriculeAdherent(matriculeadherent);
        if (bulletin == null) {
            return ResponseEntity.notFound().build();
        }

        bulletinCnamRepository.delete(bulletin);
        return ResponseEntity.ok().build();
    }
}
