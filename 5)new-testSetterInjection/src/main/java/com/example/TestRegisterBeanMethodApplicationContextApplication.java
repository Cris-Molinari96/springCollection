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
        var context = new AnnotationConfigApplicationContext(VehConfig.class);

        Person p = context.getBean(Person.class);
        p.setName("Cristian");
        System.out.println("Context spring bean --> " + p.getName() + " " + p.getDriveVehicle().getName());


    }

}
