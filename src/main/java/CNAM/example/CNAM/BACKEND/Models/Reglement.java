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
@Table(name = "Reglement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reglement {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
    @Column(name = "Code")
    private Integer code;
    
    @Column(name = "CodeEtablissement")
    private long etablissementCode;

    @Column(name = "ModeReglement")
    private String modeReglement;

    @Column(name = "DateReglement")
    private Date dateReglement;

    @Column(name = "NumCheque")
    private Long numCheque; 

    @Column(name = "Montant")
    private Double montant;

    @Column(name = "Reste")
    private Double reste;

    @Column(name = "Actif")
    private Boolean actif;
}
