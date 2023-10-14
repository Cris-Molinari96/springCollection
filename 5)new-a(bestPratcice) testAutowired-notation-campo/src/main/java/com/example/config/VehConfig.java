package com.example.config;

import com.example.bean.Person;
import com.example.bean.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.bean")
public class VehConfig {

    // 1) metodo di creazione e settaggio di un bean,
    // 2) devi seguire le seguenti impostazioni, ovvero:
        // Commentare il codice @Bean, andare nella classe Person e aggiungere la notazione @Component


    // crezione del bean, e settaggio del veicolo
    /*@Bean
    public Person person(Vehicle ferrari){
        Person p = new Person();
        p.setName("Cristian");
        ferrari.setName("Ferrari");
        p.setDriveVehicle(ferrari);
        return p;
    }*/
}
