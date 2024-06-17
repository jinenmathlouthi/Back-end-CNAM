package CNAM.example.CNAM.BACKEND.Repositories;

import CNAM.example.CNAM.BACKEND.Models.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimsRepository extends JpaRepository<Claim, Long> {

    Claim findByNumeroBsReclame(String numeroBsReclame);

}
