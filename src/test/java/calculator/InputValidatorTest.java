
package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    @Test
    void testEmptyInput() {
        assertTrue(InputValidator.isEmpty(""));
        assertTrue(InputValidator.isEmpty("   "));
    }

    @Test
    void testNonEmptyInput() {
        assertFalse(InputValidator.isEmpty("25"));
    }

    @Test
    void testValidNumbers() {
        assertTrue(InputValidator.isValidNumber("25"));
        assertTrue(InputValidator.isValidNumber("12.5"));
        assertTrue(InputValidator.isValidNumber("-10"));
    }

    @Test
    void testInvalidNumbers() {
        assertFalse(InputValidator.isValidNumber("hello"));
        assertFalse(InputValidator.isValidNumber("12abc"));
        assertFalse(InputValidator.isValidNumber(""));
    }
}
