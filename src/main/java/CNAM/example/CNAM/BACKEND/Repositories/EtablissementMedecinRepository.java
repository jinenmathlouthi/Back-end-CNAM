package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import CNAM.example.CNAM.BACKEND.Models.EtablissementMedecin;

public interface EtablissementMedecinRepository extends JpaRepository<EtablissementMedecin, Long> {
    EtablissementMedecin findByCode(Long code);
    int countByConventionne(boolean conventionne);
}
