package com.cr26code.springboot.cruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TestGlobalRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<TestErrorResponseException> globalHandler(TestGlobalException testGlobalException){
        TestErrorResponseException testErrorResponseException = new TestErrorResponseException();
        testErrorResponseException.setStatus(HttpStatus.NOT_FOUND.value());
        testErrorResponseException.setMessage(testGlobalException.getMessage());
        testErrorResponseException.setTimeStamp((int) System.currentTimeMillis());
        return new ResponseEntity<>(testErrorResponseException,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<TestErrorResponseException> globalHandler(Exception ex){
        TestErrorResponseException testErrorResponseException = new TestErrorResponseException();
        testErrorResponseException.setStatus(HttpStatus.BAD_REQUEST.value());
        testErrorResponseException.setMessage(ex.getMessage());
        testErrorResponseException.setTimeStamp((int) System.currentTimeMillis());
        return new ResponseEntity<>(testErrorResponseException,HttpStatus.BAD_REQUEST);
    }

}
