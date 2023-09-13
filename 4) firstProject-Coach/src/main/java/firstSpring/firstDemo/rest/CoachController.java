package firstSpring.firstDemo.rest;

import firstSpring.firstDemo.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// questo controller è colui che comunica col browser data l'esposizione dell'end-point, raggiunto l'end-point il controller
// comunicherà col classe component la quale gli restituirà quello che è previsto dal metodo definito nella sua classe,
// rispondendo alla richiesta dell'browser
@RestController
public class CoachController {

    private Coach myCoach; // questo rappresenta l'oggetto che vogliamo iniettare nel constr.

// inversione di controllo --> creare l'oggetto e renderlo disponibile per l'iniezione
// dependency injection --> iniettare il componente per rispondere alla richiesta


// in questo costruttore cosa facciamo, stiamo iniettando la dipendenza di cui ha bisogno, questo accade solo dopo che
// il nostro fabbricatore di oggetti abbia creato l'oggetto e quindi lo abbia instanziato per noi,
// ma non l'interfaccia ma verrà creato il footballCoach.

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
