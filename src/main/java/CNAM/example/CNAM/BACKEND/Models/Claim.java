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
@Table(name = "claims") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Claim {

    @Id
    @Column(name = "numero_bs_reclame")
    private String numeroBsReclame;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "mnt_engage")
    private Double montantEngage;

    @Column(name = "mnt_reclame")
    private Double montantReclame;

    @Column(name = "motif")
    private String motif;

    @Column(name = "date")
    private Date date;

    @Column(name = "observation")
    private String observation;

    @Column(name = "bulletin_code")
    private String bulletinCode;

    @Column(name = "num_bordereau_reclamation")
    private String numBordereauReclamation;

    @Column(name = "status")
    private String status;
}
