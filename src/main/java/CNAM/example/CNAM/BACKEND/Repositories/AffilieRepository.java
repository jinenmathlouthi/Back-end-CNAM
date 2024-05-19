package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CNAM.example.CNAM.BACKEND.Models.Affilie;
import java.util.List;


@Repository
public interface AffilieRepository extends JpaRepository<Affilie, Integer> {
    Affilie findByCode(Integer code);
    List<Affilie> findByAdherentMatricule(Integer adherentMatricule);
}
