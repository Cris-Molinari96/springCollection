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

@Bean
   public Vehicle ferrari(){
        Vehicle veh = new Vehicle();
        veh.setName("Ferraris");
        return veh;
    }

// In questo modo stiamo creando un cablaggio tra le due classi
// questo modo di passare le dipendenze è considerato un modo sporco, perchè se dovessero cambiare le dipendenze ci ritorviamo a dover modificare il codice sempre
    @Bean
    public Person person(Vehicle ferrari){
        Person p = new Person();
        p.setName("Cristian");
        p.setDriveVehicle(ferrari);
        return p;
    }
}
