package firstSpring.firstDemo.rest;

import firstSpring.firstDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach myCoach;

    CoachController(Coach theCoach){
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
