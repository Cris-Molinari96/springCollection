package com.example.bean;

import jakarta.annotation.PostConstruct;

public class Vehicle {
    private String name;

    public Vehicle(){
        System.out.println("Vehicle object sta per essere creato");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
