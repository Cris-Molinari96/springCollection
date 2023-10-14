package com.example.testhibernate.entiti.dao;


import com.example.testhibernate.entiti.Instructor;
import com.example.testhibernate.entiti.dao.interfaceImpl.InstructorRepoImpl;

public interface InstructorRepo{
    public void save(Instructor instructor);

    public Instructor findInstructor(int id);

    public void deleteInstructor(int id);

}
