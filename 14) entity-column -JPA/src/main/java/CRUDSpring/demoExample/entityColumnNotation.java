package CRUDSpring.demoExample;

import CRUDSpring.demoExample.dao.StudentDAO;
import CRUDSpring.demoExample.dao.StudentDAOImpl;
import CRUDSpring.demoExample.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class entityColumnNotation {

    public static void main(String[] args) {
        SpringApplication.run(entityColumnNotation.class, args);
    }


// Questa istruzione sarà eseguita appena verrà eseguita l'applicazione
// in questo modo l'interfaccia viene inietta da spring
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
//        creare l'oggetto
        System.out.println("Creazione dello studente");
        Student student = new Student("Marco","Adriani","fucking-marco@gmail.com");
//        salvare l'oggetto
        System.out.println("Salvataggio dello studente....");
        studentDAO.save(student);
        System.out.println("Studente salvato correttamente!!");
//        mostrare l'id dell'oggetto salvato
        System.out.println("id dell'oggetto salvato: " + student.getId());
    }
}