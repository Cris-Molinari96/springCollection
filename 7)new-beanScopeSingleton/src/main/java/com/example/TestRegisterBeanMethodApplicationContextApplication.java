package com.example;

import com.example.bean.Person;
import com.example.bean.Vehicle;
import com.example.config.ConfigClass;
import com.example.services.VehicleService;
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

        VehicleService vs = context.getBean(VehicleService.class);
        VehicleService vs2 = context.getBean("vehicleService",VehicleService.class);

// Il codice hash è un valore numerico che viene utilizzato per memorizzare e
// recuperare gli oggetti in una tabella hash.

        System.out.println("vs = " + vs.hashCode() + " " + "vs2= " + vs2.hashCode());

        if(vs == vs2){
            System.out.println(VehicleService.class.getSimpleName() + "Been scope singleton!");
        }

        vehicle.getVehicleService().getMove(); // richiamo le funzionalità dei bean
        vehicle.getVehicleService().getRuote(); // richiamo le funzionalità dei bean



    }

}
