package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CNAM.example.CNAM.BACKEND.Repositories.UtilisateurRepository;
import CNAM.example.CNAM.BACKEND.payload.request.LoginRequest;
import CNAM.example.CNAM.BACKEND.payload.response.JwtResponse;
import CNAM.example.CNAM.BACKEND.security.jwt.JwtUtils;
import CNAM.example.CNAM.BACKEND.security.services.UserDetailsImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class SignupController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilisateurRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = new ArrayList<>();

            int profilRecId = userDetails.getProfilRecId();

            if (profilRecId == 1) {
                roles.add("admin");
            } else if (profilRecId == 2) {
                roles.add("gestionnaire");
            } else {
                roles.add("utilisateur");
            }

            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    loginRequest.getUsername(),
                    roles));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nom d'utilisateur ou mot de passe incorrect.");
        }
    }
}
