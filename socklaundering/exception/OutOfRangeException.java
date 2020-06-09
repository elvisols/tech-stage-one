package socklaundering.exception;

public class OutOfRangeException extends Exception {

    public OutOfRangeException(String message) {
        super(message + " out of range exception!");
    }
}
