package test.code.token;

public class DivisionOperator implements OperatorToken {
    static final String TOKEN = "/";

    @Override
    public Integer compute(Integer first, Integer second) {
        if (second == 0) {
            throw new IllegalStateException("Cannot divide by zero!");
        }
        return first / second;
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isOperator() {
        return true;
    }

    @Override
    public String toString() {
        return TOKEN;
    }
}
