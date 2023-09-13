package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

// * Questa classe gestisce gli utenti i loro ruoli e la password per accedere ai servizi

@Configuration
public class DemoSecurityConfig {
// Aggiunta del supporto per JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

// * Questo metodo ci servirà per impostare le autorizzazioni sulle richieste http e
// * ancora una volta stiamo autorizzando in base ai ruoli determinate operazioni
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
