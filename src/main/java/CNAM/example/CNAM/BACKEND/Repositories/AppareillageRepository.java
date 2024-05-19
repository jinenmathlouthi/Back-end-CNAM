package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CNAM.example.CNAM.BACKEND.Models.Appareillage;

@Repository
public interface AppareillageRepository extends JpaRepository<Appareillage, Integer> {
    Appareillage findByCode(Integer code);
}
