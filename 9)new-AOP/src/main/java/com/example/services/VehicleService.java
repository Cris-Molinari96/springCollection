package com.example.services;

import com.example.bean.Song;
import com.example.bean.beanInterface.Ruote;
import com.example.bean.beanInterface.Stereo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.helpers.AttributesImpl;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class VehicleService {

    @Autowired
    private Stereo stereo;
    @Autowired
    private Ruote ruote;
    private Logger logger = Logger.getLogger(VehicleService.class.getName());

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

    public String playMuisc(boolean vehicleStarted, Song song){
        Instant start = Instant.now();
        logger.info("Metodo in esecuzione");
        String music = null;
        if(vehicleStarted){
            music = stereo.makeSound(song);
        }else{
            logger.log(Level.SEVERE,"Il veicolo non è pronto a partire, stereo spento");
        }
        Instant finish = Instant.now();
        Long timePassato = Duration.between(start, finish).toMillis();
        logger.info("Tempo passato dall'esecuzione del metodo" + timePassato);
        return music;
    }

    public String getMoveRuote(boolean vehicleStarted){
        Instant start = Instant.now();
        System.out.println(start);
        logger.info("Metodo in esecuzione");
        String move = null;
        if(vehicleStarted){
                move = ruote.move();
        }else{
            logger.log(Level.SEVERE,"Il veicolo non è pronto a partire, movimento disattivato");
        };
        Instant finish = Instant.now();
        Long timePassato = Duration.between(start, finish).toMillis();
        logger.info("Tempo passato dall'esecuzione del metodo" + timePassato);
        return move;
    }

    public String frena(boolean vehicleStarted){
        Instant start = Instant.now();
        logger.info("Metodo in esecuzione");
        String freno = null;
        if(vehicleStarted){
            freno = ruote.stop();
        }else{
            logger.log(Level.SEVERE,"Il veicolo non è pronto a partire, freno disattivato");
        }
        Instant finish = Instant.now();
        Long tempoPassato = Duration.between(start,finish).toMillis();
        logger.info("Tempo passato dall'esecuzione del metodo" + tempoPassato);
        return freno;
    }
}
