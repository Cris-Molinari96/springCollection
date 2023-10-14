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
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {
        "com.example.bean","com.example.services"
})
public class ConfigClass {
}
