package com.example.testhibernate;

import com.example.testhibernate.entiti.Instructor;
import com.example.testhibernate.entiti.InstructorDetails;
import com.example.testhibernate.entiti.dao.InstructorRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestHibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorRepo instructorRepo){
        return runner -> {
//            createInstructor(instructorRepo);
//            findInstructor(instructorRepo);
            deleteInstructor(instructorRepo);
        };
    }

    // questo metodo salva un istruttore nel db
    public void createInstructor(InstructorRepo instructorRepo){

        Instructor instructor = new Instructor("MM","MM","m@gmail.com");
        InstructorDetails instructorDetails = new InstructorDetails("gym","www.www");

        // oggetto associato!
        instructor.setInstructorDetails(instructorDetails);

        instructorRepo.save(instructor);

    }

    // questo metodo trova un dato utente in base all'id:
    public void findInstructor(InstructorRepo instructorRepo){
        Instructor instructor = instructorRepo.findInstructor(1);
        System.out.println(instructor.getFirstName() + " " + instructor.getLastName() + " " + instructor.getEmail());
    }
    // questo metodo ci consente di eliminare un utente
    public void deleteInstructor(InstructorRepo instructorRepo){
        instructorRepo.deleteInstructor(1);
    }
}
