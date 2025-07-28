package test.code.rpn;

import test.code.token.Token;

import java.util.List;
import java.util.stream.Collectors;

record RpnExpression(List<Token> tokens) {

    @Override
    public String toString() {
        return tokens.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
