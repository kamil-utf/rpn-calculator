package test.code.rpn;

import org.junit.jupiter.api.Test;
import test.code.token.AdditionOperator;
import test.code.token.IntegerToken;
import test.code.token.MultiplicationOperator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RpnResolverTest {
    private final RpnResolver rpnResolver = new RpnResolver();

    @Test
    void shouldEvaluateRpnExpression() {
        final var rpnExpression = new RpnExpression(List.of(
                new IntegerToken(2),
                new IntegerToken(2),
                new IntegerToken(2),
                new MultiplicationOperator(),
                new AdditionOperator()
        ));

        final var result = rpnResolver.evaluate(rpnExpression);
        assertEquals(6, result);
    }
}