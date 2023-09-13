package CRUDSpring.demoExample.dao;

import CRUDSpring.demoExample.entity.Student;

import java.util.List;
// quello che facciamo in questo file e firmare i metodi senza definire il corpo.
// se ne occuperà la classe che implementa quest'interfaccia a definire il corpo.
public interface StudentDao {
    void save(Student student);
    void saveListStudent(List<Student> studentList);
    Student findStudent(Integer id);
    List<Student> findAllStudentBySurname(String surname);
    Student findStudentByName(String name);
    List<Student> findListStudentByName(String name);
    void updateStudent(Student student);
    void updateListStudent(List<Student> studentList);

    void deleteById(Integer id);
    int deleteListStudentBySurname(String surname);
    int deleteAll();
}
