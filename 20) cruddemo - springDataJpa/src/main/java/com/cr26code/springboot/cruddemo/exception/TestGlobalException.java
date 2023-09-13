package com.cr26code.springboot.cruddemo.exception;

public class TestGlobalException extends RuntimeException{
    public TestGlobalException(String message) {
        super(message);
    }

    public TestGlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestGlobalException(Throwable cause) {
        super(cause);
    }
}
