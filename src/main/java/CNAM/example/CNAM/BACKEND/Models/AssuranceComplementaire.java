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
@Table(name = "AssuranceComplementaire")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssuranceComplementaire {

    @Id
    @Column(name = "code")
    private int code;

    @Column(name = "datesoin")
    private Date dateSoin;

    @Column(name = "totaldepense")
    private double totalDepense;

    @Column(name = "totalRemb")
    private double totalRemboursement;

    @Column(name = "matriculeAdherent")
    private String matriculeAdherents;

    @Column(name = "actif")
    private Boolean actif;

}
