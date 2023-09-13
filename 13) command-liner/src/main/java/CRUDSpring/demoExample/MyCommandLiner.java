package CRUDSpring.demoExample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyCommandLiner {

	public static void main(String[] args) {
		SpringApplication.run(MyCommandLiner.class, args);
	}

	// Questa istruzione sarà eseguita appena verrà eseguita l'applicazione
@Bean
	public CommandLineRunner commandLineRunner(String[] args){

		return runner -> {
			System.out.println("Hello World!!");
		};
	}
}