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
@Table(name = "Maladies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Maladie {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer code;

    @Column(name = "Libelle")
    private String libelle;

    @Column(name = "Actif")
    private Boolean actif;
}
