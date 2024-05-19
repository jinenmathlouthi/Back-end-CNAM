package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import CNAM.example.CNAM.BACKEND.Models.Reglement;

public interface ReglementRepository extends JpaRepository<Reglement, Integer> {
}
