package firstSpring.firstDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component
public class CricketCoach implements Coach{

    CricketCoach(){
        System.out.println("CricketCoach: Scansionato e inizializzato");
    }
    @Override
    public String getDailyWorkout() {
        return "50 cricket tiri \n" + "100 crick";
    }
}
