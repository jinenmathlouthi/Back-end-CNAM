package CNAM.example.CNAM.BACKEND.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "FichierSortie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FichierSortie {
    
    @Id
    @Column(name = "code")
    private int code;

    @Column(name = "dateSoin")
    private Date dateSoin;

    @Column(name = "regimeRemboursement")
    private String regimeRemboursement;

    @Column(name = "totalDepense")
    private int totalDepense;

    @Column(name = "actif")
    private boolean actif;

    
}
