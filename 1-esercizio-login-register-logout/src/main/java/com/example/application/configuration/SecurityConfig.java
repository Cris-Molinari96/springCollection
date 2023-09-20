package com.example.application.configuration;

import com.example.application.service.user.custom.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    /**
     * L'annotazione @Autowired inietta il servizio CustomUserDetailsService nella classe SecurityConfig
     */
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    // ! codificatore di password
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //! Permette l'accesso alle rotte `/register` e `/home` a tutti gli utenti
        http.authorizeHttpRequests(c -> c
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/register").permitAll()
                )
                //! Configura un modulo di login
                .formLogin(form -> form.loginPage("/login").
                        loginProcessingUrl("/process-form-login").permitAll()
                        .defaultSuccessUrl("/home", true).permitAll()
                )
                //! Configura un endpoint di logout
                .logout(log -> log.permitAll()
                        .invalidateHttpSession(true).
                        clearAuthentication(true).
                        logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll()
                );
        return http.build();
    }

    /**
     * Questa classe di configurazione per poter utlizzare la customizzazione riguardo l'autenticazione e l'autorizzazione di un utente deve utilizzare il servizio CustomUserDetailsService
     * e poi utilizza l'encoder per codificare le password
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
