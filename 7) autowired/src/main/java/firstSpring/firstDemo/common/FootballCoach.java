package firstSpring.firstDemo.common;

import firstSpring.firstDemo.common.Coach;
import org.springframework.stereotype.Component;

// questa classe implementa l'interfaccia coach
@Component
public class FootballCoach implements Coach {
    // sovrascrive uno dei suoi metodoi
    @Override
    public String getDailyWorkout() {
        return "Corri 5km" + "\n500 piegamenti" + "\n500 tiri"
                + "\n500 dribbling";
    }

}
