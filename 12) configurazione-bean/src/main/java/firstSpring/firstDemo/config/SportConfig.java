package firstSpring.firstDemo.config;

import firstSpring.firstDemo.common.Coach;
import firstSpring.firstDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

/* * Il caso d'uso principale dell'annotazione @Bean è quello di rendere disponibile al framework Spring
 * una classe esistente di terze parti.
 * In questi scenari, è possibile che non si abbia accesso al codice sorgente della classe di terze parti.
 * In questo modo possiamo anche utilizzare un file jar e utilizzarlo come bean
*/


// *Questo ma è marcato con la notazione @Bean perché indica a Spring Boot che il metodo deve essere utilizzato per creare un bean
    @Bean("acquatic") // id del bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
