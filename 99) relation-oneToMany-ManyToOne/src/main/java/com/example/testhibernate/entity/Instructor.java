package com.example.testhibernate.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "istruttore")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idInstructor;

    @Column(name = "name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    // questo permette di savlare un istruttore e salvare anche i suoi dettagli
    // dichiarando una join dobbiamo sempre eliminare il campo @Column se aggiunto
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_table_dettagli")
    // campo mappato nella classe Details
    private InstructorDetails instructorDetails;

    // relazione inversa, un corso può essere associato a più record della tabella  course,
    // in questo modo lo stiamo dicendo a hibernate
    @OneToMany( fetch = FetchType.EAGER,
            mappedBy = "instructor",cascade = { // --> mappato sul un campo della classe coruse
            // questo ci consente di evitare la cancellazione a cascata.
            // posso eliminare un istruttore, senza che abbia effetto sui corsi.
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    private List<Course> courseList;

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Instructor() {

    }

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetails getInstructorDetails() {
        return instructorDetails;
    }

    public void setInstructorDetails(InstructorDetails instructorDetails) {
        this.instructorDetails = instructorDetails;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    // * Possiamo crearci un metodo semplice e comodo per impostare una relazione bidirezionale
    // * quindi dall'istruttore possiamo andare ai suoi corsi, e dai corsi possiamo ricavare l'istruttore
    public void addCourse(Course course){
        if(courseList == null){
            courseList = new ArrayList<>();
        }
        courseList.add(course);
        course.setInstructor(this);
    }

    public void addSingleCourse(Course course){
        courseList.add(course);
    }
}
