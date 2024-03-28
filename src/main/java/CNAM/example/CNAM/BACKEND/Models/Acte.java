package CNAM.example.CNAM.BACKEND.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Actes")
public class Acte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private String code;

    @Column(name = "Lettre")
    private String lettre;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "Cotation")
    private Integer cotation;

    @Column(name = "PrixUnite")
    private Integer prixunite;

    public Acte(String code, String lettre, String designation, Integer cotation, Integer prixunite) {
        code = code;
        lettre = lettre;
        designation = designation;
        cotation = cotation;
        prixunite = prixunite;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        code = code;
    }

    public String getLettre() {
        return lettre;
    }

    public void setLettre(String lettre) {
        lettre = lettre;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        designation = designation;
    }

    public Integer getCotation() {
        return cotation;
    }

    public void setCotation(Integer cotation) {
        cotation = cotation;
    }

    public Integer getPrixunite() {
        return prixunite;
    }

    public void setPrixunite(Integer prixunite) {
        prixunite = prixunite;
    }

    public Acte() {
    }
}
