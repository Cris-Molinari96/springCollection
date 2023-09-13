package firstSpring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// questo controller è coloui che comunica col browser, e rende disponbile un endpoint, raggiunto l'endpoint il controller
// comunicherà col componente il quale gli restituirà quello che è previsto dal metodo, rispondendo alla richiesta dell'browser
@RestController
public class CoachController {

    private Coach myCoach;
// inversione di controllo --> creare l'oggetto e renderlo disponibile per l'inizezione
// dependency injection --> iniettare il componente per rispondere alla richiesta


    // in questo costruttore cosa facciamo, stiamo iniettando la dipendenza di cui ha bisogno, questo accade solo dopo che
    // il nostro fabbricatore di oggetti abbia creato l'oggetto e quindi lo abbia instaziato per noi, ma non l'interfaccia ma il footballCoach.

    @Autowired
    public CoachController(Coach myCoach){
        System.out.println("Sono stato creato");
        this.myCoach = myCoach;
    }

    @GetMapping("/daily-football-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
