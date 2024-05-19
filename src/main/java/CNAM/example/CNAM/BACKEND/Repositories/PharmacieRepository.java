package CNAM.example.CNAM.BACKEND.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CNAM.example.CNAM.BACKEND.Models.Pharmacie;


@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {
    Pharmacie findByCode(Long code);
}
