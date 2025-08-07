package test.code.rpn;

import org.junit.jupiter.api.Test;
import test.code.InvalidExpressionException;

import static org.junit.jupiter.api.Assertions.*;

class RpnCalculatorTest {
    private final RpnCalculator rpnCalculator = new RpnCalculator();

    @Test
    void shouldCalculateAddition() throws InvalidExpressionException {
        assertEquals(5, rpnCalculator.calculate("2 + 3"));
    }

    @Test
    void shouldCalculateMultiplicationBeforeAddition() throws InvalidExpressionException {
        assertEquals(14, rpnCalculator.calculate("2 + 3 * 4"));
    }

    @Test
    void shouldCalculateDivisionBeforeSubtraction() throws InvalidExpressionException {
        assertEquals(7, rpnCalculator.calculate("10 - 6 / 2"));
    }

    @Test
    void shouldCalculateAdditionAfterMultiplication() throws InvalidExpressionException {
        assertEquals(7, rpnCalculator.calculate("3 * 2 + 1"));
    }

    @Test
    void shouldCalculateMixedPrecedence() throws InvalidExpressionException {
        assertEquals(21, rpnCalculator.calculate("7 + 8 * 2 - 10 / 5"));
    }

    @Test
    void shouldCalculateExpressionWithNegativeValue() throws InvalidExpressionException {
        assertEquals(0, rpnCalculator.calculate("3 * -2 + 6"));
    }

    @Test
    void shouldCalculatePowerOperation() throws InvalidExpressionException {
        assertEquals(512, rpnCalculator.calculate("2 ^ 3 ^ 2"));
    }

    @Test
    void shouldThrowInvalidExpressionException() {
        assertAll(
            () -> assertThrows(InvalidExpressionException.class, () -> rpnCalculator.calculate(" ")),
            () -> assertThrows(InvalidExpressionException.class, () -> rpnCalculator.calculate("2 ++ 2")),
            () -> assertThrows(InvalidExpressionException.class, () -> rpnCalculator.calculate("2 + 2 2")),
            () -> assertThrows(InvalidExpressionException.class, () -> rpnCalculator.calculate("2 + 2 text"))
        );
    }
}