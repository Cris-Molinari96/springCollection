package RESTController.demo.controller;

import RESTController.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * in questo file stiamo creando un servizio spring REST
 * * utilizzando l'annotazione @RestController, accessibile tramite gli end-point
 */

@RestController
@RequestMapping("/test")
public class TESTController {

    private List<Student> studentList;

    // * quest'annotazione viene utilizzata quando abbiamo un metodo che vogliamo che venga eseguito
    // * appena viene creato il bean e quindi venga creata un istanza di questa classe
    @PostConstruct
    public void loadData(){
        studentList = new ArrayList<>();
        Student s = new Student("Cristian", "Molinari");
        Student s1 = new Student("Antonio", "Imperatrice");
        Student s2 = new Student("Lorenzo", "Bracci");
        Student s3 = new Student("Lorenzo", "Guidotti");
        Student s4 = new Student("Felix", "Valdez");
        Student s5 = new Student("Richard", "V");
        studentList.addAll(Arrays.asList(s, s1, s2, s3, s4, s5));
    }
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
       /* ! // primo approccio con un ciclo for, questo viene gestito con un ritorno diverso da Student
       ma viene preferito il secondo
        for (Student student : studentList) {
            if (student.getId() == id) {
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
        */
        // ! secondo approccio, anche se questo metodo non restituisce l'id effettivo ma solo l'index dello studente
        System.out.println(studentList.get(id));
        return studentList.get(id);

    }
}
