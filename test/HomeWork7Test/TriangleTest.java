package HomeWork7Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    public void testTriangleArea() {
        assertEquals(24.0, HomeWork7.Triangle.area(8, 6), 0.0001);
    }
}
