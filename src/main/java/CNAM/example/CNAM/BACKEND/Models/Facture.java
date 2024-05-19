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

import java.util.Date;

@Entity
@Table(name = "Factures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer code;

    @Column(name = "CodeFiliale")
    private Integer codeFiliale;

    @Column(name = "DateEdition")
    private Date dateEdition;

    @Column(name = "DateDebut")
    private Date dateDebut;

    @Column(name = "DateFin")
    private Date dateFin;

    @Column(name = "Cloture")
    private boolean cloture;

    @Column(name = "Montant")
    private int montant;

    @Column(name = "Actif")
    private boolean actif;

    @Column(name = "MontantRemb")
    private Integer montantRemb;

    @Column(name = "FactureEtablissements_Facture_Code")
    private Integer factureEtablissementsFactureCode;

    @Column(name = "FactureMedecins_Facture_Code")
    private Integer factureMedecinsFactureCode;

    @Column(name = "FacturePharmacies_Facture_Code")
    private Integer facturePharmaciesFactureCode;

    @Column(name = "Documents")
    private Integer documents;

    @Column(name = "MontantDepense")
    private Integer montantDepense;

    @Column(name = "A_Payer")
    private Integer aPayer;

    @Column(name = "A_Regler")
    private Integer aRegler;

    @Column(name = "Reste")
    private Integer reste;

    @Column(name = "DateArrive")
    private Date dateArrive;

    @Column(name = "Etablissement_Code")
    private String etablissementCode;

    @Column(name = "ReglementCode")
    private Integer reglementCode;

    @Column(name = "NumFacture")
    private Integer numFacture;

    @Column(name = "Reference")
    private String reference;
}
