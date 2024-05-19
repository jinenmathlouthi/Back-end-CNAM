package CNAM.example.CNAM.BACKEND.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CNAM.example.CNAM.BACKEND.Models.Utilisateur;
import CNAM.example.CNAM.BACKEND.Repositories.UtilisateurRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UtilisateurRepository utilisateurRepository;
  

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Utilisateur user = utilisateurRepository.findByLogin(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    return UserDetailsImpl.build(user);
  }

}
