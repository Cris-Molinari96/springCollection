package firstSpring.firstDemo.rest;

import firstSpring.firstDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach myCoach;

    @Autowired
    CoachController(@Qualifier("acquatic") Coach theCoach) {
        System.out.println("Controller in costruzione" + getClass().getSimpleName());
        this.myCoach = theCoach;
    }

    @GetMapping("/daily-football-workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
