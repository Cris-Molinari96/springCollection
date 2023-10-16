package com.example.testhibernate.service;

import com.example.testhibernate.entity.Instructor;
import com.example.testhibernate.repo.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public void createNewInstructor(Instructor instructor){
        instructorRepository.save(instructor);
    }
}
