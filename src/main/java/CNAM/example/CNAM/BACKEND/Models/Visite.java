package CNAM.example.CNAM.BACKEND.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Visites")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visite {
    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Libelle")
    private String libelle;

    @Column(name = "Prix")
    private Double prix;

    @Column(name = "Categorie")
    private String categorie;

    @Column(name = "Taux")
    private Double taux;

    @Column(name = "Actif")
    private Boolean actif;
}
