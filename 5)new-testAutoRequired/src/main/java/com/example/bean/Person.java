package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    //! La dipendenza non è obbligatoria, infatti è stata rimossa la notazione @Component dalla classe Vehicle
    @Autowired(required = false)
    private Vehicle driveVehicle;

   public Person(){
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

    public void setDriveVehicle(Vehicle driveVehicle) {
        this.driveVehicle = driveVehicle;
    }
}
