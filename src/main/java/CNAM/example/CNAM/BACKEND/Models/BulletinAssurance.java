package CNAM.example.CNAM.BACKEND.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "BulletinAssurance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BulletinAssurance {
    
    @Id
    @Column(name = "matriculeAdherent")
    private Long matriculeAdherent;

    @Column(name = "nom")
    private String nomAdherent;

    @Column(name = "prenom")
    private String prenomAdherent;

    @Column(name = "identifiantCNSS")
    private String ncnssAdherent;

    @Column(name = "codeMedecin")
    private Integer medecin;

    @Column(name = "filiere")
    private String filiereAdherent;

    @Column(name = "dateNaissance")
    private Date datedeNaissanceAdherent;

    @Column(name = "ancienSoldeCnam")
    private Double scnamAdherent;

    @Column(name = "soldeAssurance")
    private Double sassurAdherent;

    @Column(name = "prenomaffilie")
    private String prenomAffilie;

    @Column(name = "lienParente")
    private int lienParente;

    @Column(name = "rang")
    private int rang;

    @Column(name = "identifiantCNSSAffilie")
    private String ncnssAffilie;

    @Column(name = "filiereAffilie")
    private String filiereAffilie;

    @Column(name = "dateNaissanceAffilie")
    private Date datedeNaissanceAffilie;

    @Column(name = "soldeAssuranceAffilie")
    private int soldeAssur;

    @Column(name = "ancienSoldeCnamAffilie")
    private int sCnamAffilie;

    @Column(name = "npecConjoint")
    private int nPECConjoint;

    @Column(name = "regimeRemb")
    private String regimeremb;

    @Column(name = "apci")
    private Double apci;

    @Column(name = "dateSoin")
    private Date datedeSoins;

    @Column(name = "totalDepense")
    private Double totaldepenses;

    @Column(name = "totalrembCNAM")
    private Double totalrembCNAM;

    @Column(name = "totalremASS")
    private Double totalrembAss;

    @Column(name = "bordereau")
    private String bordereau;

    @Column(name = "observation")
    private String observations;

    @Column(name = "valide")
    private boolean valide;
    
    @Column(name = "bulletin_soin_num")
    private Long bulletinSoinNum;
    
    @Column(name = "pharmacie")
    private Integer pharmacie;

    @Column(name = "acte")
    private Double acte;

    @Column(name = "appareillage")
    private Double appareillage;
}
