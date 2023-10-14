package com.example.tescreatebean;

import com.example.tescreatebean.bean.Vehicle;
import com.example.tescreatebean.config.VehConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TesCreateBeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesCreateBeanApplication.class, args);

        // tramite l'istanza di qeust'oggetto ho accesso al contesto dove sono registrati tutti i nostri bean.
        var context = new AnnotationConfigApplicationContext(VehConfig.class);
        // tramite il metodo getBean posso catturarmi i bean di qui ho bisogno e memorizzarli in variabili.
        Vehicle audi = context.getBean("audi",Vehicle.class);
        Vehicle ferrari = context.getBean(Vehicle.class);
        Vehicle porche = context.getBean("porche",Vehicle.class);
        Vehicle lambo = context.getBean("lambo",Vehicle.class);
        System.out.println(audi.getName() + " " + "ferrari= "+ferrari.getName() + " " + porche.getName() + " " + lambo.getName());

        String hello = context.getBean(String.class);
        System.out.println(hello);



        Integer integer = context.getBean(Integer.class);
        System.out.println(integer);
    }

}
