package HomeWork7Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareNumbersTest {
    @Test
    public void testCompare() {
        assertEquals(1, HomeWork7.CompareNumbers.compare(10, 5));
        assertEquals(-1, HomeWork7.CompareNumbers.compare(5, 10));
        assertEquals(0, HomeWork7.CompareNumbers.compare(5, 5));
    }
}
