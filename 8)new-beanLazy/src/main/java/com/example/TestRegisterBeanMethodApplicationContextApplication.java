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
        System.out.println("Prima di chiamare il bean");
        // approccio lazy qui faccio riferimento al bean, e viene creata l'istanza
        Person person = context.getBean("personBean",Person.class);
        person.setName("Cristian");
        System.out.println("person created");
        Person person1 = context.getBean("personBean",Person.class);
        person1.setName("Matteo");
        System.out.println("person1 created");
        System.out.println("Dopo aver chiamato il bean");

        if (person.hashCode() != person1.hashCode()){
            System.out.println("Person hashCode: " + person.hashCode()+ "Name person:"+person.getName() + "\n" +
                    "Person1 hashCode: " + person1.hashCode() + "Person1: " + person1.getName());
        }


    }

}
