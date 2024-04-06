package CNAM.example.CNAM.BACKEND.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Medicaments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Long code;

    @Column(name = "Libelle")
    private String libelle;

    @Column(name = "Prix")
    private Double prix;

    @Column(name = "PrixPrevisionnelCnam")
    private Double prixPrevisionnelCnam;

    @Column(name = "Categorie")
    private String categorie;

    @Column(nullable = true, name = "Conventionne")
    private Boolean conventionne;

    @Column(name = "Actif")
    private Boolean actif;

   
}
