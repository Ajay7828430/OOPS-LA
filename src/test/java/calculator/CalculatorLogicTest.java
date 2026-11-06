
package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorLogicTest {

    @Test
    void testAddition() {
        assertEquals(30.0, CalculatorLogic.add(20, 10));
    }

    @Test
    void testSubtraction() {
        assertEquals(10.0, CalculatorLogic.subtract(20, 10));
    }

    @Test
    void testMultiplication() {
        assertEquals(200.0, CalculatorLogic.multiply(20, 10));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, CalculatorLogic.divide(20, 10));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(
            ArithmeticException.class,
            () -> CalculatorLogic.divide(20, 0)
        );
    }
}
