package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// * Questa classe gestisce gli utenti i loro ruoli e la password per accedere ai servizi

@Configuration
public class DemoSecurityConfig {

    // * Abbiamo creato un metodo per creare degli utenti che hanno accesso agli end-point esposti dell'applicazione
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails jhon = User.builder()
                .username("jhon")
                .password("{noop}test5678")
                .roles("EMPLOYEE")
                .build();

        UserDetails anna = User.builder()
                .username("anna")
                .password("{noop}test9101112")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails cr = User.builder()
                .username("cris")
                .password("{noop}test1234")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();


        return new InMemoryUserDetailsManager(jhon, anna, cr);
    }

// * Questo metodo ci servirà per impostare le autorizzazioni sulle richieste http e ancora una volta stiamo autorizzando in base ai ruoli determinate operazioni
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security)throws Exception{
        security.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")) ;

        // CSFR
        security.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
        security.httpBasic(Customizer.withDefaults());
        return security.build();
    }
}
