package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CNAM.example.CNAM.BACKEND.Models.FichierSortie;

@Repository
public interface FichierSortieRepository extends JpaRepository<FichierSortie, Integer> {
    FichierSortie findByCode(Integer Code); 

}
