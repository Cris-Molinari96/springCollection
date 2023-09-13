package firstSpring.firstDemo.common;

import firstSpring.firstDemo.common.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
public class FootballCoach implements Coach {
    // sovrascrive uno dei suoi metodoi

    FootballCoach(){
        System.out.println("FootballCoach: Scansionato e inizializzato");

    }

    @Override
    public String getDailyWorkout() {
        return "Corri 5km" + "\n500 piegamenti" + "\n500 tiri"
                + "\n500 dribbling";
    }

}
