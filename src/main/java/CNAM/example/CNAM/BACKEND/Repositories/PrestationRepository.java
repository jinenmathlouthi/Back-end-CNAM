package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CNAM.example.CNAM.BACKEND.Models.Prestation;

@Repository
public interface PrestationRepository extends JpaRepository<Prestation, Long> {
    Prestation findByCode(Long code);
}

