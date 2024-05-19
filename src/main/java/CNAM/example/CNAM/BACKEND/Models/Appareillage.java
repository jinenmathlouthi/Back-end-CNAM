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
@Table(name = "Appareillages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appareillage {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer code;

    @Column(name = "Libelle")
    private String libelle;

    @Column(name = "Prix")
    private Integer prix;

    @Column(name = "Actif")
    private boolean actif; 
}
