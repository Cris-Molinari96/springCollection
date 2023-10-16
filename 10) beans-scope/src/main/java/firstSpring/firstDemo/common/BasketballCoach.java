package firstSpring.firstDemo.common;

import org.springframework.stereotype.Component;
@Component
public class BasketballCoach implements Coach{

    BasketballCoach(){
        System.out.println("BasketballCoach: Scansionato e inizializzato");

    }

    @Override
    public String getDailyWorkout() {
        return "50 tiri a canestro \n" + "100 giri di campo";
    }
}
