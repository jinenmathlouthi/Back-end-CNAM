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
@Table(name = "Prestations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer code;

    @Column(name = "Libelle")
    private String libelle;

    @Column(name = "Unite")
    private String unite;

    @Column(name = "Plafond")
    private Integer plafond;

    @Column(name = "Montant")
    private Integer montant;

    @Column(name = "Pourcentage")
    private Integer pourcentage;

    @Column(name = "Rubrique")
    private String rubrique;

    @Column(name = "Formule")
    private String formule;

    @Column(name = "Retraite")
    private String retraite;

    @Column(name = "Actif")
    private Boolean actif;

    
}

