package RESTController.demo.exception;


// questa classe gestirà l'eccezione, ha bisogno di 3 campi e un costruttore
public class StudentErrorResponse {
    private int status;
    private String message;
    private int timeStamp;

    public StudentErrorResponse(){}

    public StudentErrorResponse(int status, String message, int timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }
}
