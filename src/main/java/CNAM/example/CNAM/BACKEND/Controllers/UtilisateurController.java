package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CNAM.example.CNAM.BACKEND.Models.Utilisateur;
import CNAM.example.CNAM.BACKEND.Repositories.UtilisateurRepository;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;


    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @GetMapping("/liste")
    public List<Utilisateur> getListeUtilisateurs() {
        return utilisateurRepository.findAll();
    }
}
