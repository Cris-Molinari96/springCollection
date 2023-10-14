package com.example.bean;

import com.example.bean.beanInterface.Ruote;
import org.springframework.stereotype.Component;
@Component
public class RuoteMichlen implements Ruote {

    public RuoteMichlen(){
        System.out.println("RuoteMichlen in costruzione...");
    }

    @Override
    public String move() {
        return "Mi muovo grazie alle mie ruote michlen";
    }

    @Override
    public String stop() {
        return "Il veicolo sta frenando";
    }
}
