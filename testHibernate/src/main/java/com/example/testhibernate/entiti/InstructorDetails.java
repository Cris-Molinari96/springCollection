package com.example.testhibernate.entiti;

import jakarta.persistence.*;

@Entity
@Table(name = "istruttore_dettagli")
public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instructor_details")
    private Integer idInstructorDetails;
    @Column(name = "course_instructor")
    private String courseInstructor;
    @Column(name = "youtube_chanel")
    private String ytChanel;

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
}
