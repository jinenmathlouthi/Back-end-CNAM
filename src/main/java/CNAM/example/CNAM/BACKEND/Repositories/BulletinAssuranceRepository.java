package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CNAM.example.CNAM.BACKEND.Models.BulletinAssurance;

@Repository
public interface BulletinAssuranceRepository extends JpaRepository<BulletinAssurance, Long> {
    BulletinAssurance findByMatriculeAdherent(Long matriculeAdherent);
    boolean existsByMatriculeAdherent(Integer matriculeAdherent);
    int countByValide(boolean valide);
    long count();
}
