package RESTController.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TestGlobalRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<TestGlobalErrorResponse> globalHandle(TestGlobalErrorException testGlobalErrorException){
        TestGlobalErrorResponse testGlobalErrorResponse = new TestGlobalErrorResponse();
        testGlobalErrorResponse.setStauts(HttpStatus.NOT_FOUND.value());
        testGlobalErrorResponse.setMessage("Hai lanciato un eccezione, ma per fortuna è gestita da me!!!");
        testGlobalErrorResponse.setTimeStamp((int) System.currentTimeMillis());
        return new ResponseEntity<>(testGlobalErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<TestGlobalErrorResponse> globalHandle(Exception exception){
        TestGlobalErrorResponse testGlobalErrorResponse = new TestGlobalErrorResponse();
        testGlobalErrorResponse.setStauts(HttpStatus.BAD_REQUEST.value());
        testGlobalErrorResponse.setMessage("Hai lanciato un eccezione, ma per fortuna è gestita da me!!!");
        testGlobalErrorResponse.setTimeStamp((int) System.currentTimeMillis());
        return new ResponseEntity<>(testGlobalErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
