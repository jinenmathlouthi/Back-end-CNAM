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
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer code;
     @Column(name = "Nom")
    private String nom;

    @Column(name = "Prénom")
    private String prenom;

    @Column(name = "DateNaissance")
    private Date datenaissance;

    @Column(name = "LienParente")
    private int lienparente;

    @Column(name = "Rang")
    private Integer rang;

    @Column(name = "IdentifiantCNSSConjoint")
    private String identifiantcnssconjoint;


    @Column(name = "Sexe")
    private String sexe;

    @Column(name = "Adherent_Matricule")
    private Integer adherentMatricule;




    @Column(name = "Actif")
    private Boolean actif;





    @Column(name = "APCI")
    private Boolean apci;

  
}
