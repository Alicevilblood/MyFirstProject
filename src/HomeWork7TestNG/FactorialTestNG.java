package HomeWork7TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTestNG {
    @Test
    public void testFactorial() {
        assertEquals(HomeWork7.Factorial.factorial(5), 120);
    }
}
