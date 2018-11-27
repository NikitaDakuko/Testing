import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static java.sql.Types.NULL;
import static org.junit.Assert.*;

public class TaskTriangleTest {

    @Test
    public void isTriangle() {
        assertTrue(Triangle.isTriangle(4,5,6));
    }

    @Test
    public void numbersLessThenZero() {
        assertFalse(Triangle.isTriangle(-3,-3,-2));
    }

    @Test
    public void pointAisnotCorrect() {
        assertFalse(Triangle.isTriangle(10,4,5));
    }

    @Test
    public void pointBisnotCorrect() {
        assertFalse(Triangle.isTriangle(4,10,5));
    }

    @Test
    public void pointCisnotCorrect() {
        assertFalse(Triangle.isTriangle(5,4,10));
    }

    @Test
    public void pointAequalsZero() {
        assertFalse(Triangle.isTriangle(0,5,3));
    }

    @Test
    public void pointAequalsZero() {
        assertFalse(Triangle.isTriangle(10,0,3));
    }

    @Test
    public void pointAequalsZero() {
        assertFalse(Triangle.isTriangle(6,5,0));
    }

    @Test
    public void allSidesAreEqual() {
        assertTrue(Triangle.isTriangle(5,5,5));
    }

    @Test
    public void isoscelesTriangle() {
        assertFalse(Triangle.isTriangle(9,5,9));
    }
}
