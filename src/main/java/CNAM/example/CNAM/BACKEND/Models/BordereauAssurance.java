package CNAM.example.CNAM.BACKEND.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "BordereauAssurance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BordereauAssurance {
    
    @Id
    @Column(name = "matricule_adherent")
    private Long matricule_adherent;

    @Column(name = "identifiantcnss")
    private String identifiantcnss;

    @Column(name = "adherent")
    private String adherent;

    @Column(name = "affilie")
    private String affilie;

    @Column(name = "bulletin_soin_num")
    private Long bulletinsoinnum;

    @Column(name = "datesoin")
    private Date datesoin;

    @Column(name = "prestationlibelle")
    private String  prestationlibelle;

    @Column(name = "etablissementlibelle")
    private String etablissementlibelle;

    @Column(name = "depenses")
    private double depenses;

    @Column(name = "remboursement")
    private double remboursement;
}
