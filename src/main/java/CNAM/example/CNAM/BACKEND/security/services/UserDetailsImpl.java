package CNAM.example.CNAM.BACKEND.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import CNAM.example.CNAM.BACKEND.Models.Utilisateur;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private int id;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    private Utilisateur user;

    public UserDetailsImpl(int id, String password,
            Collection<? extends GrantedAuthority> authorities, Utilisateur user) {
        this.id = id;
        this.password = password;
        this.authorities = authorities;
        this.user = user;
    }

    public static UserDetailsImpl build(Utilisateur user) {
        List<GrantedAuthority> authorities = null;

        return new UserDetailsImpl(
                user.getId(),
                user.getPassword(),
                authorities, user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }

    public int getProfilRecId() {
        return user.getProfilRecId();
    }
}
