package com.example.application.service.user.custom;

import com.example.application.model.User;
import com.example.application.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

/** * La classe CustomUserDetailsService può essere utilizzata per implementare qualsiasi tipo di servizio di autenticazione customizzato o info aggiuntive.
 * ! Questa classe è un service
 * Questa classe implementa UserDetailsService
 * è responsabile di verificare se l'utente esiste nel db per caricare le info di base dell'utente
 * qyesta classe utilizza la classe UserRepository
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    /**
     * ! Per utilizzare questa classe abbiamo bisogno di sovrascrivere il metodo loadUserByUsername di spring security per poterla utilizzare
     * ! Il metodo è responsabile del caricamento delle informazioni di base dell'utente dal database, lo fa tramite la userRepo
     * ! Il metodo SARA UTILIZZATO DA SPRING SECURITY
     * Il metodo deve restituire un oggetto di tipo UserDetail se l'utente viene trovato altrimenti lancia un eccezzione
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user.equals(null)){
            throw new UsernameNotFoundException("Username o password non valide");
        }

//        return new CustomUserDetails(user.getUsername(),user.getPassword(),grantedAuthorities(),user.getFullname()); // entrambi i modi sono corretti

        return new CustomUserDetails(user.getUsername(),user.getPassword(),Arrays.asList(new SimpleGrantedAuthority("User")),user.getFullname());
    }

    public Collection<? extends GrantedAuthority> grantedAuthorities(){
        return Arrays.asList(new SimpleGrantedAuthority("User"));
    }

}
