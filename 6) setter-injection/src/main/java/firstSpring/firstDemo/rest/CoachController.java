package firstSpring.firstDemo.rest;

import firstSpring.firstDemo.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach myCoach;

    // il primo passo per effettuare un iniezione di dipendenza dei setter
    @Autowired
    public void setMyCoach(Coach coach){
        this.myCoach = coach;
    }

    @GetMapping("/daily-football-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
