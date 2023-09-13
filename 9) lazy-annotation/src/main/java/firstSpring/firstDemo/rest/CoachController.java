package firstSpring.firstDemo.rest;

import firstSpring.firstDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach myCoach;


// Quindi abbiamo visto che anche se imposto un operatore di questo tipo, cmq i miei componenti vengono scansionati e inizializzati
    CoachController(@Qualifier("footballCoach") Coach theCoach){
        System.out.println("Controller in costruzione" + getClass());
        this.myCoach = theCoach;
    }

    // Effettuare un iniezione di dipendenza dei setter con @Qualifier
    /*@Autowired
    public void setMyCoach(@Qualifier("footballCoach") Coach coach){
        this.myCoach = coach;
    }*/

    @GetMapping("/daily-football-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
