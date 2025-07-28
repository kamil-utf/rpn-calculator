package test.code.rpn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RpnConverterTest {
    private final RpnConverter rpnConverter = new RpnConverter();

    @Test
    void shouldConvertToRpnExpression() {
        assertAll(
                () -> assertEquals("2 3 4 * +", rpnConverter.convert("2 + 3 * 4").toString()),
                () -> assertEquals("10 6 2 / -", rpnConverter.convert("10 - 6 / 2").toString()),
                () -> assertEquals("3 4 * 2 +", rpnConverter.convert("3 * 4 + 2").toString()),
                () -> assertEquals("7 8 2 * + 10 5 / -", rpnConverter.convert("7 + 8 * 2 - 10 / 5").toString())
        );
    }
}