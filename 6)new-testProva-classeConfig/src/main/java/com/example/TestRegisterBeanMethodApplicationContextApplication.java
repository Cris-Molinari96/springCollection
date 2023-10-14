package com.example;

import com.example.bean.Person;
import com.example.bean.Vehicle;
import com.example.config.ConfigClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class TestRegisterBeanMethodApplicationContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRegisterBeanMethodApplicationContextApplication.class, args);

        var context = new AnnotationConfigApplicationContext(ConfigClass.class); // ottengo il contesto dell'applicazione

        Person person = context.getBean(Person.class); // catturo il bean da container context
        Vehicle vehicle = context.getBean(Vehicle.class); // catturo il bean da container context

        vehicle.getVehicleService().getMove(); // richiamo le funzionalità dei bean
        vehicle.getVehicleService().getRuote(); // richiamo le funzionalità dei bean



    }

}
