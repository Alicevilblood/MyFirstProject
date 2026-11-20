package HomeWork7TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareNumbersTest {
    @Test
    public void testCompare() {
        assertEquals(HomeWork7.CompareNumbers.compare(10, 5), 1);
        assertEquals(HomeWork7.CompareNumbers.compare(5, 10), -1);
        assertEquals(HomeWork7.CompareNumbers.compare(5, 5), 0);
    }
}
