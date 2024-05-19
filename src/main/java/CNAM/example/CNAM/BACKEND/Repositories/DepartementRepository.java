package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CNAM.example.CNAM.BACKEND.Models.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {
    Departement findByCode(long code);
}
