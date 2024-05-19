package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CNAM.example.CNAM.BACKEND.Models.AssuranceComplementaire;

@Repository
public interface AssuranceComplementaireRepository extends JpaRepository<AssuranceComplementaire, Integer> {
    AssuranceComplementaire findByCode(int code);
}
