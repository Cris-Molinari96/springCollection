package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class MichlenRuote implements Ruote{

    MichlenRuote(){
        System.out.println("MichlenRuote object sta per essere creato");
    }
    @Override
    public String moveVehicle() {
        return "Le ruote michlen sono in movimento!";
    }
}
