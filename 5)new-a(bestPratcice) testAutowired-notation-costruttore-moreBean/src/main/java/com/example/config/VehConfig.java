package com.example.config;

import com.example.bean.Person;
import com.example.bean.Vehicle;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.bean")
public class VehConfig {

@Bean(name = "ferrari")
    Vehicle ferrari(){
    Vehicle f = new Vehicle();
    f.setName("Ferrari");
    return f;
}
// 2) caso utilizzando la notazione @Primary
@Bean(name = "audi")
    Vehicle audi(){
    Vehicle a = new Vehicle();
    a.setName("audi");
    return a;
}
@Bean(name = "mercedes")
    Vehicle mercedes(){
    Vehicle m = new Vehicle();
    m.setName("mercedes");
    return m;
}


}
