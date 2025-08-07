package test.code.token;

public class PowerOperator implements OperatorToken {
    static final String TOKEN = "^";

    @Override
    public Integer compute(Integer first, Integer second) {
        return (int) Math.pow(first, second);
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean isRightHand() {
        return true;
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isOperator() {
        return true;
    }
}
