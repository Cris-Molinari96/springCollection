package com.example;

import com.example.bean.Vehicle;
import com.example.config.VehConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TesCreateBeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesCreateBeanApplication.class, args);

        var context = new AnnotationConfigApplicationContext(VehConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println(vehicle.getName());
    }

}
