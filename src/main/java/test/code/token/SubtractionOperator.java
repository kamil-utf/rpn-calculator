package test.code.token;

public class SubtractionOperator implements OperatorToken {
    static final String TOKEN = "-";

    @Override
    public Integer compute(Integer first, Integer second) {
        return first - second;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean isRightHand() {
        return false;
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
