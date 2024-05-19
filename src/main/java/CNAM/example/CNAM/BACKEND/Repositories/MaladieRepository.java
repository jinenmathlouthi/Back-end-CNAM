package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CNAM.example.CNAM.BACKEND.Models.Maladie;

@Repository
public interface MaladieRepository extends JpaRepository<Maladie, Integer> {
    Maladie findByCode(Integer code);
}
