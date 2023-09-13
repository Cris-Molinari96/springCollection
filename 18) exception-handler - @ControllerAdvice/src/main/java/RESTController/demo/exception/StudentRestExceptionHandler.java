package RESTController.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // --> permette di definire un componente globale che estisce le eccezioni e fornisce logica di convalida personalizzate per tutti i controller all'interno dell'applicazione
public class StudentRestExceptionHandler {

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
