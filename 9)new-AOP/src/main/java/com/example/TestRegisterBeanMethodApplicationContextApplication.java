package com.example;

import com.example.bean.Person;
import com.example.bean.Song;
import com.example.bean.Vehicle;
import com.example.config.ConfigClass;
import com.example.services.VehicleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class TestRegisterBeanMethodApplicationContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRegisterBeanMethodApplicationContextApplication.class, args);

        var context = new AnnotationConfigApplicationContext(ConfigClass.class); // ottengo il contesto dell'applicazione

        var service = context.getBean(VehicleService.class);

        System.out.println(service.getClass().toString());

        Song song = new Song();
        song.setName("My friend");
        song.setSingerName("Mattia Casuccio");

        boolean accensione = false;
        boolean freno = false;

        String music = service.playMuisc(accensione,song);
//        System.out.println(service.playMuisc(accensione, song));
        String move = service.getMoveRuote(accensione);
//        System.out.println(service.getMoveRuote(accensione));
        String frena = service.frena(freno);
//        System.out.println(service.frena(accensione));

        System.out.println(music);
        System.out.println(move);
        System.out.println(frena);
    }

}
