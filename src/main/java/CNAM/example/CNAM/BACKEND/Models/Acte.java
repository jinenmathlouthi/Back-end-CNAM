package CNAM.example.CNAM.BACKEND.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Actes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Acte {
    
    @Id
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

    @Column(name = "Actif")
    private Boolean actif; 


}