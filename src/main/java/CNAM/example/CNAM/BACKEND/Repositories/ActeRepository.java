package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CNAM.example.CNAM.BACKEND.Models.Acte;



@Repository
public interface ActeRepository extends JpaRepository<Acte, String> {
    Acte findByCode(String Code);
}
