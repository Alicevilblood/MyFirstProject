package HomeWork7Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
        assertEquals(15, HomeWork7.Calculator.add(10, 5));
    }

    @Test
    public void testSubtract() {
        assertEquals(5, HomeWork7.Calculator.subtract(10, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(50, HomeWork7.Calculator.multiply(10, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2, HomeWork7.Calculator.divide(10, 5));
    }
}
