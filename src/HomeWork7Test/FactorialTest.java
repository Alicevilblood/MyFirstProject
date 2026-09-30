package HomeWork7Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @Test
    public void testFactorial() {
        assertEquals(120, HomeWork7.Factorial.factorial(5));
    }
}
