package CNAM.example.CNAM.BACKEND.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "BulletinCnam")
public class BulletinCnam {

    @Id
    @Column(name = "matriculeAdherent")
    private Long matriculeAdherent;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "filiere")
    private String filiere;

    @Column(name = "dateNaissance")
    private Date dateNaissance;

    @Column(name = "identifiantCnss")
    private String identifiantCnss;

    @Column(name = "ancienSoldeCnam")
    private Double ancienSoldeCnam;

    @Column(name = "soldeAssurance")
    private Double soldeAssurance;
    
    @Column(name = "codeMedecin")
    private Integer medecin;

    @Column(name = "prenomAffilie")
    private String prenomAffilie;

    @Column(name = "lienParente")
    private String lienParente;

    @Column(name = "rang")
    private Integer rang;

    @Column(name = "identifiantCnssAffilie")
    private Integer identifiantCNSSAffilie;

    @Column(name = "filiereAffilie")
    private String filiereAffilie;

    @Column(name = "dateNaissanceAffilie")
    private Date dateNaissanceAffilie;

    @Column(name = "soldeAssuranceAffilie")
    private Double soldeAssuranceAffilie;

    @Column(name = "ancienSoldeCnamAffilie")
    private Double ancienSoldeCnamAffilie;

    @Column(name = "npecConjoint")
    private String npecConjoint;

    @Column(name = "regimeRemb")
    private String regimeRemb;

    @Column(name = "totalDepense")
    private Double totalDepenses;

    @Column(name = "apci")
    private Double APCI;

    @Column(name = "totalRembCNAM")
    private Double totalRembCNAM;

    @Column(name = "totalRembASS")
    private Double totalRembASS;

    @Column(name = "dateSoin")
    private Date dateSoin;

    @Column(name = "pharmacie")
    private Integer pharmacie;

    @Column(name = "acte")
    private Double acte;

    @Column(name = "appareillage")
    private Double appareillage;

    @Column(name = "observation")
    private String observation;

    @Column(name = "bordereau")
    private String bordereau;
    
    @Column(name = "valide")
    private boolean valide;
    @Column(name = "bulletin_soin_num")
    private Long bulletinsoinnum;
  


}
