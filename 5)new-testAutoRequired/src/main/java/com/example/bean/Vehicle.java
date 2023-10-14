package com.example.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

public class Vehicle {
    private String name;

    public Vehicle(){
        System.out.println("Vehicle object sta per essere creato");
    }

    @PostConstruct
    public void setDrive(){
        this.name="Ferrari";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
