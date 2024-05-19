package CNAM.example.CNAM.BACKEND.Models;

import java.sql.Date;

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
@Table(name = "Affilies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Affilie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer code;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prénom")
    private String prenom;

    @Column(name = "DateNaissance")
    private Date datenaissance;

    @Column(name = "LienParente")
    private int lienParente;

    @Column(name = "Rang")
    private Integer rang;

    @Column(name = "IdentifiantCNSSConjoint")
    private String identifiantCNSSConjoint;

    @Column(name = "FiliereConjoint")
    private String filiereConjoint;

    @Column(name = "PEC_CNAM_Conjoint")
    private String pecCnamConjoint;

    @Column(name = "Sexe")
    private String sexe;

    @Column(name = "Adherent_Matricule")
    private Integer adherentMatricule;

    @Column(name = "a_charge")
    private Boolean aCharge;

    @Column(name = "a_etudiant")
    private Boolean aEtudiant;

    @Column(name = "a_endicape")
    private Boolean aEndicape;

    @Column(name = "a_primaire")
    private Boolean aPrimaire;

    @Column(name = "a_secondaire")
    private Boolean aSecondaire;

    @Column(name = "Actif")
    private Boolean actif;

    @Column(name = "CaisseAffiliation")
    private String caisseAffiliation;

    @Column(name = "SoldeAssurance")
    private Double soldeAssurance;

    @Column(name = "AncienSoldeAssurance")
    private Double ancienSoldeAssurance;

    @Column(name = "PlafonneAssurance")
    private Double plafonneAssurance;

    @Column(name = "AncienSoldeCNAM")
    private Double ancienSoldeCNAM;

    @Column(name = "APCI")
    private Boolean apci;

    @Column(name = "Maladie_Code")
    private Integer maladieCode;
}
