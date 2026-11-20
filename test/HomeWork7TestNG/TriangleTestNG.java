package HomeWork7TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleTestNG {
    @Test
    public void testTranfleArea() {
        assertEquals(HomeWork7.Triangle.area(8, 6), 24.0);
    }
}
