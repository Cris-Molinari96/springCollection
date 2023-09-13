package RESTController.demo.exception;

public class TestGlobalErrorException extends RuntimeException{
    public TestGlobalErrorException(String message) {
        super(message);
    }

    public TestGlobalErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestGlobalErrorException(Throwable cause) {
        super(cause);
    }
}
