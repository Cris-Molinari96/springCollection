package com.example;

import com.example.bean.Vehicle;
import com.example.config.VehConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

@SpringBootApplication
public class TestRegisterBeanMethodApplicationContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRegisterBeanMethodApplicationContextApplication.class, args);
        var context = new AnnotationConfigApplicationContext(VehConfig.class);

        Vehicle vehicle = new Vehicle();
        vehicle.setName("Audi");
        Supplier<Vehicle> audiSupplier = () -> vehicle;
//        System.out.println(audiSupplier.get().getName()); //! accesso alle prorpietà dell'oggetto

        // utilizzando l'interfaccia supplier la quale rappresenta un fornitore di oggetti di tipo <T> che gli viene passato negli angolari
        // possiamo accedere all'unico metodo (get) che ci restituirà un istanza di un oggetto.

        // in questo codice non creo e registro nessun bean
        Supplier<Vehicle> ferrariSupplier = () -> {
            Vehicle ferrari = new Vehicle();
            ferrari.setName("Ferrari");
            return ferrari;
        };

        int n = (int)Math.floor(Math.random() * 10);

        System.out.println(n % 2);
        if(n % 2 == 0){
            context.registerBean("audi", Vehicle.class,audiSupplier); // audiSupplier ricorda che ritorna l'istanza dell'oggetto veicolo
        }else{
            context.registerBean("ferrari", Vehicle.class,ferrariSupplier); // ferrariSupplier ricorda che ritorna l'istanza dell'oggetto veicolo
        }
        Vehicle audiV = null;
        Vehicle ferrariV = null;
        try{
            audiV = context.getBean("audi", Vehicle.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Un errore è stato riscrontrato. AudiV = null");
        }
        try{
            audiV = context.getBean("ferrari", Vehicle.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Un errore è stato riscrontrato. FerrariV = null");
        }
        if(audiV != null){
            System.out.println(audiV.getName() + " Bean registrato");
        }else{
            System.out.println(ferrariV.getName() + " Bean registrato");
        }
//        context.getBean(Vehicle.class);
    }

}
