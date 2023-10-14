package com.example.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component(value = "personBean")
public class Person {
    private String name;

    private Vehicle vehicle;
    @Autowired
    public Person(Vehicle v){
        System.out.println("Person bean in costruzione...");
        this.vehicle = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
