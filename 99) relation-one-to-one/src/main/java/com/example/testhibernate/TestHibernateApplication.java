package com.example.testhibernate;

import com.example.testhibernate.dao.interfaceImpl.InstructorRepoImpl;
import com.example.testhibernate.entity.Instructor;
import com.example.testhibernate.entity.InstructorDetails;
import com.example.testhibernate.dao.InstructorRepo;
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
    public CommandLineRunner commandLineRunner(InstructorRepoImpl instructorRepo){
        return runner -> {
//            createInstructor(instructorRepo);
//            findInstructor(instructorRepo);
//            deleteInstructor(instructorRepo);
//            instructorService.createNewInstructor(createNewInstructor());
//            findDetail(instructorRepo);
            updateDetail(instructorRepo);
        };
    }

    private void deleteDetails(InstructorRepoImpl instructorRepo) {
        instructorRepo.deleteInstructorDetails(4);
    }

    //!metodi dell'istruttore

    // questo metodo salva un istruttore nel db, classe dao
    public void createInstructor(InstructorRepo instructorRepo){

        Instructor instructor = new Instructor("Cristian","Molinari","m@gmail.com");
        InstructorDetails instructorDetails = new InstructorDetails("gym","www.www");

        // oggetto associato!
        instructor.setInstructorDetails(instructorDetails);
        instructorRepo.save(instructor);

    }

    // questo metodo trova un dato utente in base all'id, classe dao
    public void findInstructor(InstructorRepo instructorRepo){
        Instructor instructor = instructorRepo.findInstructor(1);
        System.out.println(instructor.getFirstName() + " " + instructor.getLastName() + " " + instructor.getEmail());
    }

    // questo metodo ci consente di eliminare un utente, classe dao
    public void deleteInstructor(InstructorRepo instructorRepo){
        instructorRepo.deleteInstructor(1);
    }

    // questo metodo crea un semplice istruttore
    public Instructor createNewInstructor(){

        Instructor instructor = new Instructor("MM","MM","ccm@gmail.com");
        InstructorDetails instructorDetails = new InstructorDetails("thai","www.localhost");
        instructor.setInstructorDetails(instructorDetails);
        return instructor;

    }

    // * metodi instructor details
    public void findDetail(InstructorRepoImpl instructorRepo){
        InstructorDetails instructorDetails = instructorRepo.findInstructorDetails(2);
        System.out.println(" nome istruttore: "+instructorDetails.getInstructor().getFirstName() + " " + instructorDetails.getInstructor().getLastName());
        System.out.println("id: "+instructorDetails.getIdInstructorDetails() + " \ncorso: " + instructorDetails.getCourseInstructor() + " yt chanel: " + instructorDetails.getYtChanel());
    }

    public void updateDetail(InstructorRepo instructorRepo){
        instructorRepo.updateDetail(3);
    }

}
