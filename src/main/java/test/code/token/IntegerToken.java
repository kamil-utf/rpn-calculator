package test.code.token;

public class IntegerToken implements Token {
    private final Integer value;

    public IntegerToken(Integer value) {
        this.value = value;
    }

    static IntegerToken of(String value) {
        return new IntegerToken(Integer.parseInt(value));
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
