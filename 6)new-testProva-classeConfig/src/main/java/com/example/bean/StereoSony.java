package com.example.bean;

import com.example.bean.beanInterface.Stereo;
import org.springframework.stereotype.Component;

public class StereoSony implements Stereo {

    public StereoSony(){
        System.out.println("StereoSony in costruzione...");
    }

    @Override
    public String makeSound() {
        return "Altoparlante Sony pronto ad eseguire musica";
    }
}
