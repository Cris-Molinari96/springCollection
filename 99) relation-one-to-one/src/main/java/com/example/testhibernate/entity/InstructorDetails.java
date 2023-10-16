package com.example.testhibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "istruttore_dettagi")
public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_table_dettagli")
    private Integer idInstructorDetails;
    @Column(name = "hobby")
    private String courseInstructor;
    @Column(name = "yt_chanel")
    private String ytChanel;

    // mappato sul campo della tabella padre
    @OneToOne(mappedBy = "instructorDetails",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetails(String courseInstructor, String ytChanel) {
        this.courseInstructor = courseInstructor;
        this.ytChanel = ytChanel;
    }

    public InstructorDetails() {



    }

    public Integer getIdInstructorDetails() {
        return idInstructorDetails;
    }

    public void setIdInstructorDetails(Integer idInstructorDetails) {
        this.idInstructorDetails = idInstructorDetails;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public String getYtChanel() {
        return ytChanel;
    }

    public void setYtChanel(String ytChanel) {
        this.ytChanel = ytChanel;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
