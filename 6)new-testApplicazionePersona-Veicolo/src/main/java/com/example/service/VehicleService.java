package com.example.service;

import com.example.bean.Ruote;
import com.example.bean.Stereo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {

    @Autowired
    private Stereo stereo;
    @Autowired
    private Ruote ruote;

    public Stereo getStereo() {
        return stereo;
    }

    public void setStereo(Stereo stereo) {
        this.stereo = stereo;
    }

    public Ruote getRuote() {
        return ruote;
    }


    public void setRuote(Ruote ruote) {
        this.ruote = ruote;
    }

    public void makeMusicStereo(){
        String music = stereo.makeSound();
        System.out.println(music);
    }

    public void makeVehicle(){
        String move = ruote.moveVehicle();
        System.out.println(move);
    }
}
