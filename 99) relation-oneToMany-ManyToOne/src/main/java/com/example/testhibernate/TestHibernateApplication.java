package com.example.testhibernate;

import com.example.testhibernate.dao.interfaceImpl.InstructorRepoImpl;
import com.example.testhibernate.entity.Course;
import com.example.testhibernate.entity.Instructor;
import com.example.testhibernate.entity.InstructorDetails;
import com.example.testhibernate.dao.InstructorRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestHibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorRepoImpl instructorRepo) {
        return runner -> {
//            createInstructor(instructorRepo);
//            findInstructor(instructorRepo);
//            deleteInstructor(instructorRepo);
//            instructorService.createNewInstructor(createNewInstructor());
//            findDetail(instructorRepo);
//            updateDetail(instructorRepo);

//          //! oneToMany - ManyToOne
//            createInstructor(instructorRepo);
//            createInstructor2(instructorRepo);
//            courseDetails(instructorRepo);
//            courseDetailsList(instructorRepo);
//            findCourse(instructorRepo);
//            dammiIcorsi(instructorRepo);
//            eliminaCorso(instructorRepo);
//            eliminaListaCorsi(instructorRepo);
//          //! oneToMany - ManyToOne typedQuery
//            findTypedFromIdCourse(instructorRepo);
//            courseDetailsList(instructorRepo);
            findTypedListCourse(instructorRepo);
        };
    }


    // ! typedQuery

    private void findTypedListCourse(InstructorRepoImpl instructorRepo) {
        List<Course> courseList = instructorRepo.typedFindCoursFromIdInstructor(6);
        courseList.forEach(c -> System.out.println(c.toString()));
    }
    private void findTypedFromIdCourse(InstructorRepoImpl instructorRepo) {
        Course course = instructorRepo.typedFindCourse(3);
        System.out.println(course.getCourseName() + " instructor: " + course.getInstructor().getLastName());
    }

    // ! OneToMany method
    private void eliminaListaCorsi(InstructorRepoImpl instructorRepo) {
        Integer a = 7;
        Integer b = 8;
        Integer c = 9;

        instructorRepo.deleteCourseList(Arrays.asList(a, b, c));
    }

    private void eliminaCorso(InstructorRepoImpl instructorRepo) {
        instructorRepo.deleteCourse(3);
    }

    private void dammiIcorsi(InstructorRepoImpl instructorRepo) {
        instructorRepo.getCourseIdInstructor(6);
    }

    private void findCourse(InstructorRepoImpl instructorRepo) {
        instructorRepo.courseInstructor(2);
    }

    // Questo metodo aggiunge per un istruttore n corsi
    private void courseDetailsList(InstructorRepoImpl instructorRepo) {
        Course course1 = new Course("Python");
        Course course2 = new Course("Javascript");
        Course course3 = new Course("Java");
        Course course4 = new Course("Spring");

        instructorRepo.addListCourseInCourseTable(6, Arrays.asList(course1, course2, course3, course4));
    }

    private void courseDetails(InstructorRepoImpl instructorRepo) {
        instructorRepo.addCourseInCourseTable(6, new Course("KickBox"));
    }

    private void createInstructor2(InstructorRepoImpl instructorRepo) {
        Instructor instructor = new Instructor("GGG2", "GGGG", "gg.@gmail.com");
        InstructorDetails instructorDetails = new InstructorDetails("0023", "www.gg.ytchanel.com");
        Course course = new Course("FootballCourse");
        instructor.addCourse(course); // mi evito un passgio in questo modo ossia di associare i campi course e istruttore
        instructor.setInstructorDetails(instructorDetails);
        instructorRepo.save(instructor);
    }

    private void deleteDetails(InstructorRepoImpl instructorRepo) {
//        instructorRepo.deleteInstructorDetails(4);
    }

    //!metodi dell'istruttore

    // questo metodo salva un istruttore nel db, classe dao
    public void createInstructor(InstructorRepo instructorRepo) {
        Instructor instructor = new Instructor("MMFMER", "FWENIU", "m@gmail.com");
        InstructorDetails instructorDetails = new InstructorDetails("0001", "www.www");
        List<Course> courseList = new ArrayList<>();
        Course course = new Course("Thai MUAY");
        courseList.add(course);


        // oggetto instructor associato!
        instructor.setInstructorDetails(instructorDetails);
        // stiamo aggiungendo l'array corsi all'istruttore che accetta una lista di corsi
        instructor.setCourseList(courseList);
        course.setInstructor(instructor);

        instructorRepo.save(instructor);
    }

    // questo metodo trova un dato utente in base all'id, classe dao
    public void findInstructor(InstructorRepo instructorRepo) {
        Instructor instructor = instructorRepo.findInstructor(1);
        System.out.println(instructor.getFirstName() + " " + instructor.getLastName() + " " + instructor.getEmail());
    }

    // questo metodo ci consente di eliminare un utente, classe dao
    public void deleteInstructor(InstructorRepo instructorRepo) {
        instructorRepo.deleteInstructor(1);
    }

    // questo metodo crea un semplice istruttore
    public Instructor createNewInstructor() {

        Instructor instructor = new Instructor("MM", "MM", "ccm@gmail.com");
        InstructorDetails instructorDetails = new InstructorDetails("thai", "www.localhost");
        instructor.setInstructorDetails(instructorDetails);
        return instructor;

    }

    // * metodi instructor details
    public void findDetail(InstructorRepoImpl instructorRepo) {
        InstructorDetails instructorDetails = instructorRepo.findInstructorDetails(2);
        System.out.println(" nome istruttore: " + instructorDetails.getInstructor().getFirstName() + " " + instructorDetails.getInstructor().getLastName());
        System.out.println("id: " + instructorDetails.getIdInstructorDetails() + " \ncorso: " + instructorDetails.getCourseInstructor() + " yt chanel: " + instructorDetails.getYtChanel());
    }

    public void updateDetail(InstructorRepo instructorRepo) {
        instructorRepo.updateDetail(3);
    }

}
