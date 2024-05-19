package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CNAM.example.CNAM.BACKEND.Models.SuiviBordereau;

@Repository
public interface SuiviBordereauRepository extends JpaRepository<SuiviBordereau, String> {
    SuiviBordereau findByNumeroBS(String numeroBS);
}
