package CNAM.example.CNAM.BACKEND.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Utilisateurs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
private Integer id;
@Column(name = "Login")
private String login;
@Column(name = "Password")
private String Password;

@Column(name = "Status")
private String status;
}
