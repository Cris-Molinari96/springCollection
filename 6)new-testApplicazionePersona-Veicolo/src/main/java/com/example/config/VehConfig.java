package com.example.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.example.bean",
        "com.example.service"})
//@ComponentScan(basePackageClasses = {com.example.bean.Vehicle.class,
//        com.example.bean.Person.class})
public class VehConfig {
}
