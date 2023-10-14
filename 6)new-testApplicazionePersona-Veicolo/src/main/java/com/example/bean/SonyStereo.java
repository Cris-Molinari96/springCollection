package com.example.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonyStereo implements Stereo{


    SonyStereo(){
        System.out.println("StereoSony object sta per essere creato");
    }

    @Override
    public String makeSound() {
        return "Musica riprodotta dallo stereo sony";
    }
}
