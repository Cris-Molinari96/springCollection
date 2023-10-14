package com.example.services;

import com.example.bean.beanInterface.Ruote;
import com.example.bean.beanInterface.Stereo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
public class VehicleService {
    @Autowired
    private Stereo stereo;
    @Autowired
    private Ruote ruote;

    public VehicleService(Stereo stereo, Ruote ruote){
        this.stereo = stereo;
        this.ruote = ruote;
    }

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

    public void getSound(){
        String music = stereo.makeSound();
        System.out.println(music);
    }
    public void getMove(){
        String move = ruote.move();
        System.out.println(move);
    }
}
