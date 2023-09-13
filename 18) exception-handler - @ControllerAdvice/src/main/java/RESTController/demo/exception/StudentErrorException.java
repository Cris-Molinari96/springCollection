package RESTController.demo.exception;


// questa classe sarà utilizzabile ovunque nel codice e sarà lanciata quando non viene trovato uno studente
public class StudentErrorException extends RuntimeException{

    public StudentErrorException(String message) {
        super(message);
    }

    public StudentErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentErrorException(Throwable cause) {
        super(cause);
    }
}
