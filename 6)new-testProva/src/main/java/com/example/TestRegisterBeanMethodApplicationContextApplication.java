package com.example;

import com.example.bean.Person;
import com.example.bean.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class TestRegisterBeanMethodApplicationContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRegisterBeanMethodApplicationContextApplication.class, args);
        var context = new AnnotationConfigApplicationContext();

        Person person = context.getBean(Person.class);
        Vehicle vehicle = context.getBean(Vehicle.class);

        vehicle.getVehicleService().getMove();
        vehicle.getVehicleService().getRuote();



    }

}
