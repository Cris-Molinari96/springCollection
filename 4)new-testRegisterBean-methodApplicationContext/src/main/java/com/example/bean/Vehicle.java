package com.example.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

public class Vehicle {
    private String name;

//    @PostConstruct
//    public void postConstruct(){
//        this.name="Ferrari";
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
