package CNAM.example.CNAM.BACKEND.Controllers;

import CNAM.example.CNAM.BACKEND.Models.Claim;
import CNAM.example.CNAM.BACKEND.Repositories.ClaimsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ClaimsController {

    @Autowired
    private ClaimsRepository claimsRepository;

    @GetMapping("/claims")
    public ResponseEntity<List<Claim>> getAllClaims() {
        List<Claim> claims = claimsRepository.findAll();
        return ResponseEntity.ok(claims);
    }

    @GetMapping("/claims/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Optional<Claim> claim = claimsRepository.findById(id);
        return claim.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/claims")
public ResponseEntity<?> createClaims(@RequestBody Claim claims) {
    Claim existingClaims = claimsRepository.findByNumeroBsReclame(claims.getNumeroBsReclame());
    if (existingClaims != null) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Le claim existe déjà.");
    }

    Claim createdClaims = claimsRepository.save(claims);
    return new ResponseEntity<>(createdClaims, HttpStatus.CREATED);
}


    @PutMapping("/claims/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @RequestBody Claim claimDetails) {
        Optional<Claim> optionalClaim = claimsRepository.findById(id);
        if (optionalClaim.isPresent()) {
            Claim claim = optionalClaim.get();
            claim.setNumeroBsReclame(claimDetails.getNumeroBsReclame());
            claim.setLibelle(claimDetails.getLibelle());
            claim.setMontantEngage(claimDetails.getMontantEngage());
            claim.setMontantReclame(claimDetails.getMontantReclame());
            claim.setMotif(claimDetails.getMotif());
            claim.setDate(claimDetails.getDate());
            claim.setObservation(claimDetails.getObservation());
            claim.setBulletinCode(claimDetails.getBulletinCode());
            claim.setNumBordereauReclamation(claimDetails.getNumBordereauReclamation());
            claim.setStatus(claimDetails.getStatus());

            Claim updatedClaim = claimsRepository.save(claim);
            return ResponseEntity.ok(updatedClaim);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/claims/{id}")
    public ResponseEntity<HttpStatus> deleteClaim(@PathVariable Long id) {
        try {
            claimsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
