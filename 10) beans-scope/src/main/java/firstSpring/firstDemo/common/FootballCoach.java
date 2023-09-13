package firstSpring.firstDemo.common;

import firstSpring.firstDemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FootballCoach implements Coach {
    // questa classe sovrascrive un metodo della superclasse

    FootballCoach(){
        System.out.println("FootballCoach: Scansionato e inizializzato");
    }

    @Override
    public String getDailyWorkout() {
        return "Corri 5km" + "\n500 piegamenti" + "\n500 tiri"
                + "\n500 dribbling";
    }

}
