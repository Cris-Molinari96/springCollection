package RESTController.demo.exception;

public class TestGlobalErrorResponse {
    private int stauts;
    private String message;
    private int timeStamp;

    public TestGlobalErrorResponse(int stauts, String message, int timeStamp) {
        this.stauts = stauts;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public TestGlobalErrorResponse(){}

    public int getStauts() {
        return stauts;
    }

    public void setStauts(int stauts) {
        this.stauts = stauts;
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
