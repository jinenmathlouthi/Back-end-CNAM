package CNAM.example.CNAM.BACKEND.Models;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Medecins")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementMedecin {
  
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Long code;

    @Column(name = "Libelle")
    private String libelle;

    @Column(name = "Type")
    private String type;

    @Column(name = "Cle")
    private Long cle;

    @Column(name = "DateAdhesion")
    private Date dateAdhesion;

    @Column(name = "Adresse_locale")
    private String adresseLocale;

    @Column(name = "Conventionne")
    private Boolean conventionne;

    @Column(name = "Actif")
    private Boolean actif;

   
}
