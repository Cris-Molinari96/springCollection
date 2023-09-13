package RESTController.demo.controller;

import RESTController.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if(id >= studentList.size() || id < 0){
            throw new StudentErrorException("Non è stato possibile trovare nessuno studente" + id);
        }
        System.out.println(studentList.get(id));
        return studentList.get(id);
    }

    /* * Aggiunta del gestore di eccezioni, che setta la risposta*/
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentErrorException studentErrorException){
        // dobbiamo adesso utilizzare la nostra classe di risposta per settarla con i valori dell'eccezione
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(studentErrorException.getMessage());
        studentErrorResponse.setTimeStamp((int) System.currentTimeMillis());
        // ritornare una risposta di errore, e lo stato della richiesta
        // ci ritorna uno
        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }


    /* ? Aggiunta di un secondo gestore per catturare tutti i tipi di eccezione */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(ex.getMessage());
        studentErrorResponse.setTimeStamp((int) System.currentTimeMillis());
        // ritornare una risposta di errore, e lo stato della richiesta
        // ci ritorna uno
        return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);
    }

}
