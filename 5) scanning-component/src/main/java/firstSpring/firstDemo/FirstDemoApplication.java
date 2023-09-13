package firstSpring.firstDemo;

// avremo questo file generato da spring.
// questo file ha di seguito un importazione fondamentale che permette:

// Quest'importazione ci consente di avviare un applicazione spring-boot
import org.springframework.boot.SpringApplication;
// la configurazione automatica, la scansione dei componenti e la configurazione aggiuntiva con spring boot, questa è la seconda.
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Avviata l'applicazione spring boot avvierà la scansione automatica di tutti i pacchetti contenuti nel package dove risiede questo file, partendo prima da questo
// Se avessimo bisogno di altri pacchetti non contenuti in questo package, bisognerà indicare il percorso

@SpringBootApplication(
		scanBasePackages = {"firstSpring.util", "firstSpring.firstDemo"} // <-- in questo modo stiamo specificando i pacchetti che devono essere scansionati, per l'esecuzione corretta dell'applicazione
)
public class FirstDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstDemoApplication.class, args);
	}

}
