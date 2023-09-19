package com.example.application.service.user.custom;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
/**
 * Questa classe implementa UserDetails, e rappresenta le informazioni di base di un utente
 * è responsabile dell'autenticazione e autorizzazione degli utenti alle risorse protette*/
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthority;
    private String fullname;
    /*
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    */

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> grantedAuthority,String fullname) {
        this.username = username;
        this.password = password;
        this.grantedAuthority = grantedAuthority;
        this.fullname = fullname; // il full-name sarà utilizzato nella schermata principale
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true; // enabled
    }
}
