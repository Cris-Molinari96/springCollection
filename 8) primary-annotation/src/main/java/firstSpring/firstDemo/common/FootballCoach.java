package firstSpring.firstDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// * la notazione primary ci dice che fin tanto questa è posizionata in questo modo,verrà utilizzata quest'implementazione di coach di default, quindi liberandoci dell'operatore qualifier
@Primary
@Component
public class FootballCoach implements Coach {

    // sovrascrive uno dei suoi metodoi
    @Override
    public String getDailyWorkout() {
        return "Corri 5km" + "\n500 piegamenti" + "\n500 tiri"
                + "\n500 dribbling";
    }

}
