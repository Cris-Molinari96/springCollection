package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    // la dipendenza viene iniettata, configurata nella classe Config
    private final Vehicle driveVehicle; // per il final il bean dev'essere istanziato dal costruttore di classe

   /* //! primo caso
    @Autowired
    public Person(Vehicle ferrari){
        this.driveVehicle = ferrari;
        System.out.println("Person object sta per essere istanziato");
    }*/

  /* //! secondo caso
  @Autowired
    public Person(Vehicle vehicle){
        this.driveVehicle = vehicle;
        System.out.println("Person object sta per essere istanziato");
    }*/

    /*  //! terzo caso
  @Autowired
    public Person(Vehicle vehicle){
        this.driveVehicle = vehicle;
        System.out.println("Person object sta per essere istanziato");
    }*/

  @Autowired
    public Person(Vehicle audi){
        this.driveVehicle = audi;
        System.out.println("Person object sta per essere istanziato");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getDriveVehicle() {
        return driveVehicle;
    }

}
