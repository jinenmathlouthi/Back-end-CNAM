package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CNAM.example.CNAM.BACKEND.Models.Medicament;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
    Medicament findByCode(Long code);
}
