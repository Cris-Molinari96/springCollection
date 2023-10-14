package com.example.bean;

import com.example.services.VehicleService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Vehicle {
    private String modelVehicle;
    private final VehicleService vehicleService;
    @Autowired
    public Vehicle(VehicleService vs){
        this.vehicleService = vs;
    }

    public void setModelVehicle(){
        this.modelVehicle = "Ferari";
    }

    public String getModelVehicle() {
        return modelVehicle;
    }

    public void setModelVehicle(String modelVehicle) {
        this.modelVehicle = modelVehicle;
    }

    public VehicleService getVehicleService() {
        return vehicleService;
    }
}
