package firstSpring.firstDemo.rest;

import firstSpring.firstDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// ? In questo esercizio sto creando due beans i quali puntano a due aree diverse in memoria, occuperanno due slot diversi

@RestController
public class CoachController {
    private Coach myCoach;
    private Coach secondCoach;


/* ! VERIFICA SE STIAMO UTILIZZANDO LO STESSO BEAN */
// * Ambito singleton --> in questo caso queste due referenze, fanno riferimento,puntano alla stessa instanza
// * Ambito prototype --> queste due istanze puntano a due aree diverse della memoria e quindi a due bean diversi

    CoachController(@Qualifier("footballCoach") Coach theCoach,
                    @Qualifier("footballCoach") Coach secondCoach){
        System.out.println("Controller in costruzione" + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.secondCoach = secondCoach;
    }

 // Effettuare un iniezione di dipendenza dei setter con @Qualifier
    /*@Autowired
    public void setMyCoach(@Qualifier("ballCoach") Coach coach){
        this.myCoach = coach;
    }*/

    @GetMapping("/daily-football-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

//    Check per individuare se entrambi gli oggetti puntano alla stessa area di memoria,
// * ambito singleton --> come puoi immaginare che la memoria condivisa è sempre quella quindi ritornerà true
// * ambito prototype --> mentre nell'ambito prototype ritornerà un valore false,
// * perchè l'area di memoria condivisa è diversa essendo due istanza diverse, questo succede perchè vengono create
// * ogni volta che si ha bisogno delle dipendenze di un componente
    @GetMapping("/check")
    public String getCheckBean(){
        String check = String.valueOf(myCoach == secondCoach);
        return "Comparazione di questi due bean nell'ambito prototype: theCoach == secondCoach:"
                + " " + check;
    }
}
