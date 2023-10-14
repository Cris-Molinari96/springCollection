package com.example.bean;

public class Person {
    private String name;
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
