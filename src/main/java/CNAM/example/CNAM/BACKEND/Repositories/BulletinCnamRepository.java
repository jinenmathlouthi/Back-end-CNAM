package CNAM.example.CNAM.BACKEND.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CNAM.example.CNAM.BACKEND.Models.BulletinCnam;

@Repository
public interface BulletinCnamRepository extends JpaRepository<BulletinCnam, Long> {
    BulletinCnam findByMatriculeAdherent(Long matriculeAdherent);
    boolean existsByMatriculeAdherent(Integer matriculeAdherent);
    int countByValide(boolean valide);
    long count();
}
