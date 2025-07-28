package test.code.token;

public interface OperatorToken extends Token {
    Integer compute(Integer first, Integer second);
    int getPriority();
}
