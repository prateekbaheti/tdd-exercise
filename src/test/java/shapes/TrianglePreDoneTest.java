package shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrianglePreDoneTest {

    @Test
    public void shouldReturnThePerimeterAs10() throws Exception {
        TrianglePreDone triangle = new TrianglePreDone(4, 2, 4);
        assertEquals(10, triangle.perimeter());
    }

    @Test
    public void isTriangleRightAngle() throws Exception {
        TrianglePreDone triangle = new TrianglePreDone(3, 4, 5);
        assertTrue(triangle.isRightAngle());
    }

    @Test
    public void isTriangleRightAngleWhenLastSideNotHighest() throws Exception {
        TrianglePreDone triangle = new TrianglePreDone(4, 5, 3);
        assertTrue(triangle.isRightAngle());
    }

    @Test
    public void isNotARightAngleTriangle() throws Exception {
        TrianglePreDone triangle = new TrianglePreDone(2, 4, 5);
        assertFalse(triangle.isRightAngle());
    }
}