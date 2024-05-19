package CNAM.example.CNAM.BACKEND.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CNAM.example.CNAM.BACKEND.Models.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {
    Facture findByCode(Integer code);
   
    List<Facture> findAllByDateFinIsNotNull();
    long count();
}
