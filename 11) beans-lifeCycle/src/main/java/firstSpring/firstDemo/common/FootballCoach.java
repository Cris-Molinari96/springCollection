package firstSpring.firstDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    // questa classe sovrascrive un metodo della super classe

    FootballCoach(){
        System.out.println("FootballCoach: Scansionato e inizializzato");
    }

    /* * Inoltre stiamo analizzando anche queste due annotazioni che mi permettono di:
    ! indicare i metodi di inizializzazione e distruzione di un bean gestito dal container spring,
    ! questi vengono eseguiti automaticamente da spring durante il ciclo di vita del bean stesso
    * */
    // definisci il tuo metodo postCostruttore, quindi questo viene eseguito alla creazione del bean
    @PostConstruct
    public void coseDiAvvio(){
        System.out.println("nelle mie cose di avvio: " + getClass().getSimpleName());
    }

    // e definisci il tuo metodo preDistruzione del bean il predestroy viene attivato quando l'applicazione termina
    @PreDestroy
    public void coseDistrutte(){
        System.out.println("nelle mie cose di distruzione:" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Corri 5km" + "\n500 piegamenti" + "\n500 tiri"
                + "\n500 dribbling";
    }

}
