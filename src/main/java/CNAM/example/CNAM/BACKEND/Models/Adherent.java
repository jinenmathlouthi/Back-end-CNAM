package CNAM.example.CNAM.BACKEND.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Adherents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Adherent {
    @Id
   
    @Column(name = "Matricule")
    private long matricule;

    @Column(name = "IdentifiantCNSS")
    private String identifiantcnss;

    @Column(name = "CIN")
    private String cin;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "DateNaissance")
    private Date datenaissance;

    @Column(name = "LieuNaissance")
    private String lieunaissance;

    @Column(name = "DateEmbauche")
    private Date dateembauche;

    @Column(name = "Sexe")
    private String sexe;

    @Column(name = "SituationFamiliale")
    private String situationfamiliale;

    @Column(name = "CaisseAffiliation")
    private String caisseaffiliation;

    @Column(name = "SoldeCNAM")
    private Double soldecnam;

    @Column(name = "Plafonne")
    private Boolean plafonne;

    @Column(name = "Retraite")
    private Boolean retraite;

    @Column(name = "PlafonneAssurance")
    private Boolean plafonneassurance;

    @Column(name = "PersonneCharge")
    private Boolean personnecharge;

    @Column(name = "APCI")
    private Boolean apci;

  

    @Column(name = "Actif")
    private Boolean actif;


    @Column(name = "Filiere")
    private String filiere;

    @Column(name = "Adresse_Locale")
    private String adresse_locale;

    @Column(name = "Territoire")
    private String territoire;

    @Column(name = "NombreEnfants")
    private Integer nombreenfants;

    @Column(name = "Rib")
    private String rib;

    @Column(name = "SoldeAssurance")
    private Double soldeassurance;

    @Column(name = "Medecin_Code")
    private String medecin_code;

    @Column(name = "AncienSoldeAssurance")
    private Double anciensoldeassurance;

    @Column(name = "AncienSoldeCNAM")
    private Double anciensoldecnam;

    @Column(name = "CarteCNSS")
    private byte[] cartecnss;

    @Column(name = "Photo")
    private byte[] photo;

    @Column(name = "Statut")
    private String statut;

    @Column(name = "DateCIN")
    private Date datecin;

    @Column(name = "NumAdherent")
    private String numadherent;

    @Column(name = "Nationalité")
    private String nationalite;

    @Column(name = "Maladie_Code")
    private String maladie_code;

    @Column(name = "Departement_Code")
    private String departement_code;

    @Column(name = "Qualification_Code")
    private String qualification_code;

    @Column(name = "Service_Code")
    private String service_code;

    @Column(name = "Etablissement_Code")
    private String etablissement_code;
  
    
}
