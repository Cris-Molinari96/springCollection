package com.example.config;

import com.example.bean.Person;
import com.example.bean.RuoteMichlen;
import com.example.bean.StereoSony;
import com.example.bean.Vehicle;
import com.example.bean.beanInterface.Ruote;
import com.example.bean.beanInterface.Stereo;
import com.example.services.VehicleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.example.bean","com.example.services"
})
public class ConfigClass {
    // Come puoi vedere nella classe di confiugrazione vengono creati i bean, non sto utilizzando nessun autowired, alla fine tutto consiste che le dipendenze vengano iniettate
    @Bean //! dipende da veicolo service
    Vehicle vehicle(){
        Vehicle v = new Vehicle(vehicleService());
        v.setModelVehicle("Ferrari");
        return v;
    }
    @Bean //! dipende da veicolo
    Person person(){
        Person p = new Person(vehicle());
        p.setName("Cristian");
        p.setVehicle(vehicle());
        return p;
    }
    @Bean //! dipende da ruote e stereo
    VehicleService vehicleService(){
        VehicleService vs = new VehicleService(stereoSony(),ruoteMichlen());
        vs.getMove();
        vs.getSound();
        return vs;
    }
    @Bean //! non dipende da nessuno ma implementa l'interfaccia Ruote
    Ruote ruoteMichlen(){
        Ruote r = new RuoteMichlen();
        return r;
    }
    @Bean //! non dipende da nessuno ma implementa l'interfaccia Stereo
    Stereo stereoSony(){
        Stereo s = new StereoSony();
        return s;
    }
}
