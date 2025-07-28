package test.code.token;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenFactoryTest {

    private final TokenFactory tokenFactory = new TokenFactory();

    @Test
    void shouldCreateIntegerToken() {
        final var twoToken = tokenFactory.create("2");
        assertInstanceOf(IntegerToken.class, twoToken);
        assertEquals(2, ((IntegerToken) twoToken).getValue());

        final var sixtySixToken = tokenFactory.create("66");
        assertInstanceOf(IntegerToken.class, sixtySixToken);
        assertEquals(66, ((IntegerToken) sixtySixToken).getValue());

        final var negativeFiveToken = tokenFactory.create("-5");
        assertInstanceOf(IntegerToken.class, negativeFiveToken);
        assertEquals(-5, ((IntegerToken) negativeFiveToken).getValue());
    }

    @Test
    void shouldCreateAdditionOperatorToken() {
        assertInstanceOf(AdditionOperator.class, tokenFactory.create("+"));
    }

    @Test
    void shouldCreateSubtractionOperatorToken() {
        assertInstanceOf(SubtractionOperator.class, tokenFactory.create("-"));
    }

    @Test
    void shouldCreateMultiplicationOperatorToken() {
        assertInstanceOf(MultiplicationOperator.class, tokenFactory.create("*"));
    }

    @Test
    void shouldCreateDivisionOperatorToken() {
        assertInstanceOf(DivisionOperator.class, tokenFactory.create("/"));
    }
}