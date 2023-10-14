package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class BoseStereo implements Stereo{


    @Override
    public String makeSound() {
        return "Musica riprodotta dallo stereo BOSE";
    }
}
