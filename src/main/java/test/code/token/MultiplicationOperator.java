package test.code.token;

public class MultiplicationOperator implements OperatorToken {
    static final String TOKEN = "*";

    @Override
    public Integer compute(Integer first, Integer second) {
        return first * second;
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
