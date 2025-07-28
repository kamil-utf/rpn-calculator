package test.code.rpn;

import test.code.token.IntegerToken;
import test.code.token.OperatorToken;
import test.code.token.Token;

import java.util.Stack;

class RpnResolver {

    Integer evaluate(RpnExpression expression) {
        final var stack = new Stack<Token>();

        for (Token token : expression.tokens()) {
            if (token.isNumber()) {
                stack.push(token);
            } else if (token.isOperator()) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Not enough operands for operator");
                }

                final var operandB = stack.pop();
                final var operandA = stack.pop();

                stack.push(compute(operandA, (OperatorToken) token, operandB));
            } else {
                throw new IllegalArgumentException("Invalid token in expression");
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Leftover operands");
        }

        final var result = stack.pop();
        assertNumberToken(result);
        return ((IntegerToken) result).getValue();
    }

    private IntegerToken compute(Token a, OperatorToken operator, Token b) {
        assertNumberToken(a);
        final var aValue = ((IntegerToken) a).getValue();

        assertNumberToken(b);
        final var bValue = ((IntegerToken) b).getValue();

        return new IntegerToken(operator.compute(aValue, bValue));
    }

    private void assertNumberToken(Token token) {
        if (!token.isNumber()) {
            throw new IllegalArgumentException("Token should be number");
        }
    }
}
