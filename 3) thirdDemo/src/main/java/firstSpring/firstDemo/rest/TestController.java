package firstSpring.firstDemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    // richiamo le proprietà personalizzate con questa notation
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    @Value("${number.team}")
    private Integer numberTeam;

     private StringBuilder strBuilder = new StringBuilder();


    // new end-point
    @GetMapping("/welcome")
    public StringBuilder getWelcome(){
        strBuilder.append("Benvenuto Coach " + coachName + "!!!\n" + "Team: " + teamName + "\n"
        + "Numero giocatori: " + numberTeam);
        return strBuilder;
    }

}
