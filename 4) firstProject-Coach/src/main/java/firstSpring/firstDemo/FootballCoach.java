package firstSpring.firstDemo;

import org.springframework.stereotype.Component;

// questa classe implementa l'interfaccia coach
@Component
public class FootballCoach implements Coach{



    FootballCoach(){
        System.out.println("FootballCoach");
    }

    // sovrascrive uno dei suoi metodoi
    @Override
    public String getDailyWorkout() {
        return "Corri 5km" + "\n500 piegamenti" + "\n500 tiri"
                + "\n500 dribbling";
    }

}
