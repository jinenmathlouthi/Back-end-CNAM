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
@Table(name = "SuiviBordereau")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuiviBordereau {
    
    @Id
    @Column(name = "B_envoi")
    private String bEnvoi;

    @Column(name = "MatriculeAdherents")
    private Integer matriculeAdherents;

    @Column(name = "Prestataire")
    private String prestataire;

    @Column(name = "NumeroBS")
    private String numeroBS;

    @Column(name = "DateEmission")
    private Date dateEmission;

    @Column(name = "Prestation")
    private String prestation;

    @Column(name = "Etablissement")
    private String etablissement;

    @Column(name = "Montant")
    private double montant;

    @Column(name = "MontantFacture")
    private double montantFacture;
}
