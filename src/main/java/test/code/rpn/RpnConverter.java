package test.code.rpn;

import test.code.token.OperatorToken;
import test.code.token.Token;
import test.code.token.TokenFactory;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class RpnConverter {
    private final TokenFactory tokenFactory;

    RpnConverter() {
        this.tokenFactory = new TokenFactory();
    }

    RpnExpression convert(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        final var output = new ArrayList<Token>();
        final var stack = new Stack<OperatorToken>();

        final var tokenizer = new StringTokenizer(expression);
        while (tokenizer.hasMoreTokens()) {
            final var token = tokenFactory.create(tokenizer.nextToken());
            if (token.isNumber()) {
                output.add(token);
            } else if (token.isOperator()) {
                final var tokenOperator = (OperatorToken) token;
                while (!stack.isEmpty()
                        && (!tokenOperator.isRightHand() && tokenOperator.getPriority() <= stack.peek().getPriority())
                        && (tokenOperator.isRightHand() && tokenOperator.getPriority() < stack.peek().getPriority())) {
                    output.add(stack.pop());
                }
                stack.push(tokenOperator);
            } else {
                throw new IllegalArgumentException("Unsupported token");
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return new RpnExpression(output);
    }
}
