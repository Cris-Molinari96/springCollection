package com.example.testhibernate.dao.interfaceImpl;

import com.example.testhibernate.dao.InstructorRepo;
import com.example.testhibernate.entity.Course;
import com.example.testhibernate.entity.Instructor;
import com.example.testhibernate.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

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
        return entityManager.find(Instructor.class, id);
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
        return entityManager.find(InstructorDetails.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetails(int id) {
        InstructorDetails instructorDetails = entityManager.find(InstructorDetails.class, id);

        instructorDetails.getInstructor().setInstructorDetails(null);

//        System.out.println("Eliminazione dell'istruttore..." + instructorDetails.getInstructor().getFirstName() + " " + instructorDetails.getInstructor().getLastName());
        entityManager.remove(instructorDetails);

        System.out.println("dettagli istruttore eliminati" + instructorDetails.getCourseInstructor() + instructorDetails.getInstructor().getLastName());
    }

    @Override
    @Transactional
    public void updateDetail(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        InstructorDetails instructorDetails = new InstructorDetails("thai", "www.www.localhost");
        instructor.setInstructorDetails(instructorDetails);
        instructorDetails.setInstructor(instructor);

        entityManager.persist(instructorDetails);
        System.out.println("Aggiornati");
    }

    @Override
//    @Transactional
    public void addCourseInCourseTable(int id, Course course) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        instructor.addSingleCourse(course);
        course.setInstructor(instructor);
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public void addListCourseInCourseTable(int id, List<Course> course) {

        Instructor instructor = entityManager.find(Instructor.class, id);

        course.forEach(c -> {
            Course course1 = c;
            instructor.addSingleCourse(course1);
            course1.setInstructor(instructor);
            entityManager.persist(course1);
        });

    }

    @Override
    public void courseInstructor(int id) {
        Course course = entityManager.find(Course.class, id);
        System.out.println(course.getInstructor().getFirstName() + " " + course.getInstructor().getLastName());
    }

    @Override
//    @Transactional
    public void getCourseIdInstructor(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        instructor.getCourseList().forEach(c -> {
            System.out.println(instructor.getFirstName() + " " +
                    instructor.getLastName() + " " +
                    "Corsi associati: " + c.getCourseName());
        });
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
        System.out.println(course.getCourseName() + " removed");
    }

    @Override
//    @Transactional
    public void deleteCourseList(List<Integer>courseList) {
        for (Integer courseId : courseList) {
            Course course = entityManager.find(Course.class,courseId);
            entityManager.remove(course);
            System.out.println(course.getCourseName() + " removed");
        }
    }

    @Override
    public Course typedFindCourse(int id) {
        TypedQuery<Course> typedQuery = entityManager.createQuery("FROM Course where id = :id", Course.class);
        typedQuery.setParameter("id",id);

        return typedQuery.getSingleResult();
    }

    @Override
    public List<Course> typedFindCoursFromIdInstructor(int id) {
        TypedQuery<Course> typedQuery = entityManager.createQuery("FROM Course where instructor.id = :id", Course.class);
        typedQuery.setParameter("id",id);

        return typedQuery.getResultList();
    }


}
