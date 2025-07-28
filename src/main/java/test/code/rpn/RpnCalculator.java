package test.code.rpn;

import test.code.Calculator;
import test.code.InvalidExpressionException;

public class RpnCalculator implements Calculator {
    private final RpnConverter rpnConverter;
    private final RpnResolver rpnResolver;

    public RpnCalculator() {
        this.rpnConverter = new RpnConverter();
        this.rpnResolver = new RpnResolver();
    }

    @Override
    public Integer calculate(String expression) throws InvalidExpressionException {
        try {
            final var rpnExpression = rpnConverter.convert(expression);

            return rpnResolver.evaluate(rpnExpression);
        } catch (IllegalArgumentException ex) {
            throw new InvalidExpressionException(ex.getMessage());
        }
    }
}
