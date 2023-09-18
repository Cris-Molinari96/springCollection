package CRUDSpring.demoExample.dao;

import CRUDSpring.demoExample.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.StubNotFoundException;
import java.util.List;

// questa classe è responsabile di paralre col database, considerata come una repository, ossia come un
// componente per la persistenza dei dati
// per le classi contrassegnate come repository spring offre supporto per l'autowired.
@Repository
public class StudentDaoImpl implements StudentDao {
    // è il gestore che fa la connessione
    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // ! SAVE - CREATE
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void saveListStudent(List<Student> studentList) {
        for (Student student : studentList) {
            entityManager.persist(student);
        }
    }

    // ! READ
    // per i metodi di lettura dati nel db non abbiamo bisogno di trattare questo
    // metodo con un comportamento transazionale, in quanto non stiamo salvando o sovrascrivendo dati nel db
    @Override
    public Student findStudent(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllStudentBySurname(String surname) {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student where lastName = :lastName", Student.class);
        typedQuery.setParameter("lastName", surname);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    // nelle query, si fa riferimento all'entità e non alla tabella
    // cosi come per i campi dell'entità e non sui campi della tabella
    @Override
    public Student findStudentByName(String name) {

        TypedQuery<Student> typedQuery = entityManager.createQuery("from Student where firstName = :theName", Student.class);
        typedQuery.setParameter("theName", name);
        Student myStudent = typedQuery.getSingleResult();

        return myStudent;
    }

    @Override
    public List<Student> findListStudentByName(String name) {
        return null;
    }

    // ! UPDATE
    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateListStudent(List<Student> studentList) {

        for (Student student : studentList) {
            entityManager.merge(student);
        }

    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Student s = findStudent(id);
        entityManager.remove(s);
    }

    // vedi in questo metodo stiamo eliminando tutti gli studenti dal database che hanno un cognome = a quello
    // che gli viene passato come parametro
    @Override
    @Transactional
    public int deleteListStudentBySurname(String surname) {
        Query query = entityManager.createQuery("delete from Student where lastName = :lastName");
        query.setParameter("lastName", surname);
        int x = query.executeUpdate();
        System.out.println("Eliminati con successo");
        return x;
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRows = entityManager.createQuery("delete from Student").executeUpdate();
        return numRows;
    }

}
