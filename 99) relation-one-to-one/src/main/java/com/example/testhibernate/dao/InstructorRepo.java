package com.example.testhibernate.dao;


import com.example.testhibernate.entity.Instructor;
import com.example.testhibernate.entity.InstructorDetails;

public interface InstructorRepo{

    public void save(Instructor instructor);

    public Instructor findInstructor(int id);

    public void deleteInstructor(int id);

    public InstructorDetails findInstructorDetails(int id);

    public void deleteInstructorDetails(int id);

    public void updateDetail(int id);

}
