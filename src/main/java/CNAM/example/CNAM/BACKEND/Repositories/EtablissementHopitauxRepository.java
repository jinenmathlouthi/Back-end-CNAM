package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import CNAM.example.CNAM.BACKEND.Models.EtablissementHopitaux;

@Repository
public interface EtablissementHopitauxRepository extends JpaRepository<EtablissementHopitaux, Long> {
    EtablissementHopitaux findByCode(Long code);
}
