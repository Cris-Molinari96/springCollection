package com.example.testhibernate.dao.interfaceImpl;

import com.example.testhibernate.dao.InstructorRepo;
import com.example.testhibernate.entity.Instructor;
import com.example.testhibernate.entity.InstructorDetails;
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

    @Override
    public InstructorDetails findInstructorDetails(int id) {
        return entityManager.find(InstructorDetails.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetails(int id) {
        InstructorDetails instructorDetails = entityManager.find(InstructorDetails.class,id);

        instructorDetails.getInstructor().setInstructorDetails(null);

//        System.out.println("Eliminazione dell'istruttore..." + instructorDetails.getInstructor().getFirstName() + " " + instructorDetails.getInstructor().getLastName());
        entityManager.remove(instructorDetails);

        System.out.println("dettagli istruttore eliminati" + instructorDetails.getCourseInstructor() + instructorDetails.getInstructor().getLastName());
    }

    @Override
    @Transactional
    public void updateDetail(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        InstructorDetails instructorDetails = new InstructorDetails("thai","www.www.localhost");
        instructor.setInstructorDetails(instructorDetails);
        instructorDetails.setInstructor(instructor);

        entityManager.persist(instructorDetails);
        System.out.println("Aggiornati");
    }


}
