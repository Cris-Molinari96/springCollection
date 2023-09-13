package firstSpring.firstDemo.rest;

import firstSpring.firstDemo.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach myCoach;

    /* ! VERIFICA SE STIAMO UTILIZZANDO LO STESSO BEAN */
    // * Ambito singleton --> in questo caso queste due referenze, fanno riferimento,puntano alla stessa instanza
    // * Ambito prototype --> queste due istanze puntano a due aree diverse della memoria e quindi a due bean diversi

    CoachController(@Qualifier("footballCoach") Coach theCoach) {
        System.out.println("Controller in costruzione" + getClass().getSimpleName());
        this.myCoach = theCoach;
    }


    @GetMapping("/daily-football-workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
