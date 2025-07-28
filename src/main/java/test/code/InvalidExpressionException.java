package test.code;

public class InvalidExpressionException extends Exception {
    public InvalidExpressionException(String message) {
        super("Invalid expression: " + message);
    }
}
