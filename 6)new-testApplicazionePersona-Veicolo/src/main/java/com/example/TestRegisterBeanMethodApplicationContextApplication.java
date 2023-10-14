package com.example;

import com.example.bean.Person;
import com.example.bean.Vehicle;
import com.example.config.VehConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

@SpringBootApplication
public class TestRegisterBeanMethodApplicationContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRegisterBeanMethodApplicationContextApplication.class, args);
        var context = new AnnotationConfigApplicationContext(VehConfig.class)   ;

//        String[] persons = context.getBeanNamesForType(Person.class);
        Person person = context.getBean(Person.class);

//        String[] vehicles = context.getBeanNamesForType(Vehicle.class);
        Vehicle vehicle = context.getBean(Vehicle.class);

        vehicle.getVehicleService().makeMusicStereo();
        vehicle.getVehicleService().makeVehicle();

    }

}
