package com.example.tescreatebean.config;

import com.example.tescreatebean.bean.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehConfig {
    @Bean(name = "audi")
    Vehicle veh(){
        var v = new Vehicle();
        v.setName("Audi");
        return v;
    }

    @Bean(name = "ferrari")
    Vehicle veh1(){
        var v = new Vehicle();
        v.setName("Ferrari");
        return v;
    }

    @Bean(name = "porche")
    Vehicle veh2(){
        var v = new Vehicle();
        v.setName("Porche");
        return v;
    }

    @Bean(name = "lambo")
    Vehicle veh3(){
        var v = new Vehicle();
        v.setName("Lamborghini");
        return v;
    }

    @Bean
    String str(){
        return "Hello world!!";
    }

    @Bean
    Integer integer(){
        return 16;
    }

}
