package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CNAM.example.CNAM.BACKEND.Models.Visite;

@Repository
public interface VisiteRepository extends JpaRepository<Visite, String> {
    Visite findByCode(String code);
}
