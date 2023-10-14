package com.example.testhibernate.entiti.dao.interfaceImpl;

import com.example.testhibernate.entiti.Instructor;
import com.example.testhibernate.entiti.dao.InstructorRepo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorRepoImpl implements InstructorRepo {
    private EntityManager entityManager;

    @Autowired
    public InstructorRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructor(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {
        Instructor instructor = findInstructor(id);
        entityManager.remove(instructor);
        System.out.println("Instruttore rimosso" + instructor.getIdInstructor());
    }

}
