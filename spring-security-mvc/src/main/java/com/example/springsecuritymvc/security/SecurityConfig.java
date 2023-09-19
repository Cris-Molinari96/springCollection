package com.example.springsecuritymvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig {

    /** ? Supporto JDBC
     * ! Qui si dice a spring di usare l'autenticazione JDBC con la nostra fonte dati
     * ! Inietto l'origine dei dati
     * Questo dirà */
@Bean
public UserDetailsManager userDetailsManager(DataSource dataSource){
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from memberscustom where user_id=?");
    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from rolescustom where user_id=?");
    return jdbcUserDetailsManager;
}


// * Primo passo: definire il percorso del login modificando quindi la configurazione di base di Spring Security
// * utilizziamo il filtro per andare ad intercettare la richiesta d'accesso al nostro end-point e gli facciamo vedere il nostro login
// * i dati username e password saranno inviati ("authenticateTheUser")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form ->
                        form
                                .loginPage("/mostra-login") //! creazione controller per questa mappatura (LoginController gestirà la mappatura)
                                // quando si tenterà di accedere alla nostra home o qualsiasi altro dominio, verrà richiamata questa pagina per
                                // effettuare il login, infatti creiamo un controller mappato su quest'end-point
                                .loginProcessingUrl("/autenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                ).exceptionHandling(configurer -> configurer.accessDeniedPage("/accesso-negato"));
        return httpSecurity.build();
    }

    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails giovanni = User.builder()
                .username("Giovanni")
                .password("{noop}test1234")
                .roles("EMPLOYEE")
                .build();

        UserDetails maria = User.builder()
                .username("Maria")
                .password("{noop}test5678")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails paolo = User.builder()
                .username("Paolo")
                .password("{noop}test2468")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(giovanni, maria, paolo);
    }*/
}
