package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CNAM.example.CNAM.BACKEND.Models.Adherent;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Integer> {
    Adherent findByMatricule(int matricule);
}

