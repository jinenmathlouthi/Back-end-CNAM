package CNAM.example.CNAM.BACKEND.Controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import CNAM.example.CNAM.BACKEND.Models.BordereauAssurance;
import CNAM.example.CNAM.BACKEND.Models.BulletinAssurance;

import CNAM.example.CNAM.BACKEND.Repositories.BordereauAssuranceRepository;
import CNAM.example.CNAM.BACKEND.Repositories.BulletinAssuranceRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/assurance")
public class BulletinAssuranceController {

    @Autowired
    private BulletinAssuranceRepository bulletinAssuranceRepository;
    @Autowired
    private BordereauAssuranceRepository bordereauAssuranceRepository;

    @GetMapping("/bulletins")
    public List<BulletinAssurance> getAllBulletins() {
        return bulletinAssuranceRepository.findAll();
    }

    @GetMapping("/bulletins/{matriculeadherent}")
    public ResponseEntity<BulletinAssurance> getBulletinById(@PathVariable(value = "matriculeadherent") Long matriculeadherent) {
        BulletinAssurance bulletin = bulletinAssuranceRepository.findByMatriculeAdherent(matriculeadherent);
        if (bulletin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(bulletin);
    }

     @PostMapping("/bulletins")
public ResponseEntity<BulletinAssurance> createBulletin(@RequestBody BulletinAssurance bulletin) {
   
    Long bulletinSoinNum = generateUniqueBulletinNum();
    bulletin.setBulletinSoinNum(bulletinSoinNum);
  
    BulletinAssurance createdBulletin = bulletinAssuranceRepository.save(bulletin);
    BordereauAssurance bordereauAssurance = new BordereauAssurance();
    bordereauAssurance.setMatricule_adherent(bulletin.getMatriculeAdherent());
    bordereauAssurance.setBulletinsoinnum(bulletin.getBulletinSoinNum());
    bordereauAssurance.setAdherent(bulletin.getNcnssAdherent() + " " + bulletin.getPrenomAdherent());
    bordereauAssurance.setIdentifiantcnss(bulletin.getNcnssAdherent());
    bordereauAssurance.setAffilie(bulletin.getNomAdherent() + bulletin.getPrenomAffilie());
    bordereauAssurance.setBulletinsoinnum(bulletin.getBulletinSoinNum());
    bordereauAssurance.setDatesoin(bulletin.getDatedeSoins());
    bordereauAssurance.setPrestationlibelle(bulletin.getObservations());
    bordereauAssurance.setEtablissementlibelle(String.valueOf(bulletin.getMedecin()));
    bordereauAssurance.setRemboursement(bulletin.getTotalrembAss());
    bordereauAssurance.setDepenses(bulletin.getTotaldepenses());
    bordereauAssuranceRepository.save(bordereauAssurance);
    bordereauAssuranceRepository.save(bordereauAssurance);

    return ResponseEntity.status(HttpStatus.CREATED).body(createdBulletin);
}

    

   private Long generateUniqueBulletinNum() {
    Random random = new Random();
    return (long) (random.nextInt(9000) + 1000);
}


    @PutMapping("/bulletins/{matriculeadherent}")
    public ResponseEntity<BulletinAssurance> updateBulletin(@PathVariable(value = "matriculeadherent") Long matriculeadherent,
            @RequestBody BulletinAssurance bulletinDetails) {
        BulletinAssurance bulletin = bulletinAssuranceRepository.findByMatriculeAdherent(matriculeadherent);
        if (bulletin == null) {
            return ResponseEntity.notFound().build();
        }

        BulletinAssurance savedBulletin = bulletinAssuranceRepository.save(bulletinDetails);
        return ResponseEntity.ok(savedBulletin);
    }

    @DeleteMapping("/bulletins/{matriculeadherent}")
    public ResponseEntity<?> deleteBulletin(@PathVariable(value = "matriculeadherent") Long matriculeadherent) {
        BulletinAssurance bulletin = bulletinAssuranceRepository.findByMatriculeAdherent(matriculeadherent);
        if (bulletin == null) {
            return ResponseEntity.notFound().build();
        }

        bulletinAssuranceRepository.delete(bulletin);
        return ResponseEntity.ok().build();
    }

  
}
