package HomeWork7TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTestNG {
    @Test
    public void testAdd() {
        assertEquals(HomeWork7.Calculator.add(10, 5), 15);
    }

    @Test
    public void testSubtract() {
        assertEquals(HomeWork7.Calculator.subtract(10, 5), 5);
    }

    @Test
    public void testMultiply() {
        assertEquals(HomeWork7.Calculator.multiply(10, 5), 50);
    }

    @Test
    public void testDivide() {
        assertEquals(HomeWork7.Calculator.divide(10, 5), 2);
    }
}
