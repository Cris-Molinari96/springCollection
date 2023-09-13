package RESTController.demo.controller;

import RESTController.demo.entity.Student;
import RESTController.demo.exception.TestGlobalErrorException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

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
        // ? dobbiamo fare un check per lanciare la nostra eccezione, e in quel modo stiamo creando e lanciando una nuova eccezione con quel messaggio di errore
        // * in questo modo stiamo gestendo il tipo di eccezione lanciato da un numero negativo o da un numero maggiore della sice
        // * gestendo anche il tipo di eccezione che viene generato se vengono passate delle lettere o qualsiasi tipo di eccezione
        if(id >= studentList.size() || id < 0){
            throw new TestGlobalErrorException("Non è stato possibile trovare nessuno studente" + id);
        }
        System.out.println(studentList.get(id));
        return studentList.get(id);
    }






}
